package com.bycyjs.md.service.impl;


import com.bycyjs.md.mapper.FrontMapper;
import com.bycyjs.md.model.CodeStyle;
import com.bycyjs.md.model.Pager;
import com.bycyjs.md.pojo.Front;
import com.bycyjs.md.pojo.Tool;
import com.bycyjs.md.service.MdService;
import com.bycyjs.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.image.attributes.ImageAttributesExtension;
import org.commonmark.ext.task.list.items.TaskListItemsExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class MdServiceImpl implements MdService {

    @Autowired
    private FrontMapper frontMapper;
    @Autowired
    private RestTemplate restTemplate;

    /*分页查询*/
    @Override
    public R findByFrontPager(Integer page, Integer size) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        List<Front> list = frontMapper.findByFrontPager(params);
        Pager<Front> pager = new Pager<Front>();
        pager.setData(list);
        pager.setTotal(frontMapper.findUFront());
        return R.success(pager);

    }

    @Override
    public R addFront(HttpServletRequest request, MultipartFile file) throws IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String originalFilename = file.getOriginalFilename();
        String time = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        Front front = new Front();
        front.setFilename(originalFilename);
        front.setTime(time);
        Front front1 = frontMapper.selectFront(front);
        /*判断以前是上传过该文件名的文件*/
        /*if(front1!=null){

        }*/


        InputStream inputStream = file.getInputStream();
        File file1 = new File("E:\\file\\md\\learnnote\\Front\\" + time);

        if (!file1.exists()) {
            file1.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\file\\md\\learnnote\\Front\\" + time + "\\" + originalFilename);
        /*执行文件拷贝*/
        IOUtils.copy(inputStream, fileOutputStream);

        frontMapper.addFront(front);


        return R.success("success");
    }

    @Override
    public R selectFront(String time, String filename) throws IOException {
        time = time.substring(0, 10);
        String flie = "E:\\file\\md\\learnnote\\Front\\" + time + "\\" + filename;
        String file=txt2String(new File(flie));
        List<Extension> extensions = Arrays.asList(TablesExtension.create(),
                ImageAttributesExtension.create(), TaskListItemsExtension.create());
        Parser parser = Parser.builder()
                .extensions(extensions)
                .build();
        /*Node document = parser.parse("This is *Sparta*");*/
        Node document= parser.parse(file);
        /*System.out.println(document);*/
        HtmlRenderer renderer = HtmlRenderer
                .builder()
                .nodeRendererFactory(new HtmlNodeRendererFactory() {
                    @Override
                    public NodeRenderer create(HtmlNodeRendererContext htmlNodeRendererContext) {
                        return new CodeStyle(htmlNodeRendererContext);
                    }
                })
                .build();
        String html= renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        Tool tool=new Tool();
        html=tool.getHtmltop()+tool.getStyle()+tool.getHtmlcenter()+html+tool.getJs()+tool.getHtmldown();

        return R.success(html);


    }

    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            // 构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // 使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


}
