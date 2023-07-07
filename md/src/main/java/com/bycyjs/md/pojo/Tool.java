package com.bycyjs.md.pojo;

import lombok.Data;

@Data
public class Tool {
    private String style="  <style>\n" +
            "      /**\n" +
            " * prism.js Github theme based on GitHub's theme.\n" +
            " * @author Sam Clarke\n" +
            " */\n" +
            "code[class*=\"language-\"],\n" +
            "pre[class*=\"language-\"] {\n" +
            "  color: #333;\n" +
            "  background: none;\n" +
            "  font-family: Consolas, \"Liberation Mono\", Menlo, Courier, monospace;\n" +
            "  text-align: left;\n" +
            "  white-space: pre;\n" +
            "  word-spacing: normal;\n" +
            "  word-break: normal;\n" +
            "  word-wrap: normal;\n" +
            "  line-height: 1.4;\n" +
            "\n" +
            "  -moz-tab-size: 8;\n" +
            "  -o-tab-size: 8;\n" +
            "  tab-size: 8;\n" +
            "\n" +
            "  -webkit-hyphens: none;\n" +
            "  -moz-hyphens: none;\n" +
            "  -ms-hyphens: none;\n" +
            "  hyphens: none;\n" +
            "}\n" +
            "\n" +
            "/* Code blocks */\n" +
            "pre[class*=\"language-\"] {\n" +
            "  padding: .8em;\n" +
            "  overflow: auto;\n" +
            "  /* border: 1px solid #ddd; */\n" +
            "  border-radius: 3px;\n" +
            "  /* background: #fff; */\n" +
            "  background: #f5f5f5;\n" +
            "}\n" +
            "\n" +
            "/* Inline code */\n" +
            ":not(pre) > code[class*=\"language-\"] {\n" +
            "  padding: .1em;\n" +
            "  border-radius: .3em;\n" +
            "  white-space: normal;\n" +
            "  background: #f5f5f5;\n" +
            "}\n" +
            "\n" +
            ".token.comment,\n" +
            ".token.blockquote {\n" +
            "  color: #969896;\n" +
            "}\n" +
            "\n" +
            ".token.cdata {\n" +
            "  color: #183691;\n" +
            "}\n" +
            "\n" +
            ".token.doctype,\n" +
            ".token.punctuation,\n" +
            ".token.variable,\n" +
            ".token.macro.property {\n" +
            "  color: #333;\n" +
            "}\n" +
            "\n" +
            ".token.operator,\n" +
            ".token.important,\n" +
            ".token.keyword,\n" +
            ".token.rule,\n" +
            ".token.builtin {\n" +
            "  color: #a71d5d;\n" +
            "}\n" +
            "\n" +
            ".token.string,\n" +
            ".token.url,\n" +
            ".token.regex,\n" +
            ".token.attr-value {\n" +
            "  color: #183691;\n" +
            "}\n" +
            "\n" +
            ".token.property,\n" +
            ".token.number,\n" +
            ".token.boolean,\n" +
            ".token.entity,\n" +
            ".token.atrule,\n" +
            ".token.constant,\n" +
            ".token.symbol,\n" +
            ".token.command,\n" +
            ".token.code {\n" +
            "  color: #0086b3;\n" +
            "}\n" +
            "\n" +
            ".token.tag,\n" +
            ".token.selector,\n" +
            ".token.prolog {\n" +
            "  color: #63a35c;\n" +
            "}\n" +
            "\n" +
            ".token.function,\n" +
            ".token.namespace,\n" +
            ".token.pseudo-element,\n" +
            ".token.class,\n" +
            ".token.class-name,\n" +
            ".token.pseudo-class,\n" +
            ".token.id,\n" +
            ".token.url-reference .token.variable,\n" +
            ".token.attr-name {\n" +
            "  color: #795da3;\n" +
            "}\n" +
            "\n" +
            ".token.entity {\n" +
            "  cursor: help;\n" +
            "}\n" +
            "\n" +
            ".token.title,\n" +
            ".token.title .token.punctuation {\n" +
            "  font-weight: bold;\n" +
            "  color: #1d3e81;\n" +
            "}\n" +
            "\n" +
            ".token.list {\n" +
            "  color: #ed6a43;\n" +
            "}\n" +
            "\n" +
            ".token.inserted {\n" +
            "  background-color: #eaffea;\n" +
            "  color: #55a532;\n" +
            "}\n" +
            "\n" +
            ".token.deleted {\n" +
            "  background-color: #ffecec;\n" +
            "  color: #bd2c00;\n" +
            "}\n" +
            "\n" +
            ".token.bold {\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            "\n" +
            ".token.italic {\n" +
            "  font-style: italic;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/* JSON */\n" +
            ".language-json .token.property {\n" +
            "  color: #183691;\n" +
            "}\n" +
            "\n" +
            ".language-markup .token.tag .token.punctuation {\n" +
            "  color: #333;\n" +
            "}\n" +
            "\n" +
            "/* CSS */\n" +
            "code.language-css,\n" +
            ".language-css .token.function {\n" +
            "  color: #0086b3;\n" +
            "}\n" +
            "\n" +
            "/* YAML */\n" +
            ".language-yaml .token.atrule {\n" +
            "  color: #63a35c;\n" +
            "}\n" +
            "\n" +
            "code.language-yaml {\n" +
            "  color: #183691;\n" +
            "}\n" +
            "\n" +
            "/* Ruby */\n" +
            ".language-ruby .token.function {\n" +
            "  color: #333;\n" +
            "}\n" +
            "\n" +
            "/* Markdown */\n" +
            ".language-markdown .token.url {\n" +
            "  color: #795da3;\n" +
            "}\n" +
            "\n" +
            "/* Makefile */\n" +
            ".language-makefile .token.symbol {\n" +
            "  color: #795da3;\n" +
            "}\n" +
            "\n" +
            ".language-makefile .token.variable {\n" +
            "  color: #183691;\n" +
            "}\n" +
            "\n" +
            ".language-makefile .token.builtin {\n" +
            "  color: #0086b3;\n" +
            "}\n" +
            "\n" +
            "/* Bash */\n" +
            ".language-bash .token.keyword {\n" +
            "  color: #0086b3;\n" +
            "}\n" +
            "\n" +
            "/* highlight */\n" +
            "pre[data-line] {\n" +
            "  position: relative;\n" +
            "  padding: 1em 0 1em 3em;\n" +
            "}\n" +
            "pre[data-line] .line-highlight-wrapper {\n" +
            "  position: absolute;\n" +
            "  top: 0;\n" +
            "  left: 0;\n" +
            "  background-color: transparent;\n" +
            "  display: block;\n" +
            "  width: 100%;\n" +
            "}\n" +
            "\n" +
            "pre[data-line] .line-highlight {\n" +
            "  position: absolute;\n" +
            "  left: 0;\n" +
            "  right: 0;\n" +
            "  padding: inherit 0;\n" +
            "  margin-top: 1em;\n" +
            "  background: hsla(24, 20%, 50%,.08);\n" +
            "  background: linear-gradient(to right, hsla(24, 20%, 50%,.1) 70%, hsla(24, 20%, 50%,0));\n" +
            "  pointer-events: none;\n" +
            "  line-height: inherit;\n" +
            "  white-space: pre;\n" +
            "}\n" +
            "\n" +
            "pre[data-line] .line-highlight:before, \n" +
            "pre[data-line] .line-highlight[data-end]:after {\n" +
            "  content: attr(data-start);\n" +
            "  position: absolute;\n" +
            "  top: .4em;\n" +
            "  left: .6em;\n" +
            "  min-width: 1em;\n" +
            "  padding: 0 .5em;\n" +
            "  background-color: hsla(24, 20%, 50%,.4);\n" +
            "  color: hsl(24, 20%, 95%);\n" +
            "  font: bold 65%/1.5 sans-serif;\n" +
            "  text-align: center;\n" +
            "  vertical-align: .3em;\n" +
            "  border-radius: 999px;\n" +
            "  text-shadow: none;\n" +
            "  box-shadow: 0 1px white;\n" +
            "}\n" +
            "\n" +
            "pre[data-line] .line-highlight[data-end]:after {\n" +
            "  content: attr(data-end);\n" +
            "  top: auto;\n" +
            "  bottom: .4em;\n" +
            "}html body{font-family:\"Helvetica Neue\",Helvetica,\"Segoe UI\",Arial,freesans,sans-serif;font-size:16px;line-height:1.6;color:#333;background-color:#fff;overflow:initial;box-sizing:border-box;word-wrap:break-word}html body>:first-child{margin-top:0}html body h1,html body h2,html body h3,html body h4,html body h5,html body h6{line-height:1.2;margin-top:1em;margin-bottom:16px;color:#000}html body h1{font-size:2.25em;font-weight:300;padding-bottom:.3em}html body h2{font-size:1.75em;font-weight:400;padding-bottom:.3em}html body h3{font-size:1.5em;font-weight:500}html body h4{font-size:1.25em;font-weight:600}html body h5{font-size:1.1em;font-weight:600}html body h6{font-size:1em;font-weight:600}html body h1,html body h2,html body h3,html body h4,html body h5{font-weight:600}html body h5{font-size:1em}html body h6{color:#5c5c5c}html body strong{color:#000}html body del{color:#5c5c5c}html body a:not([href]){color:inherit;text-decoration:none}html body a{color:#08c;text-decoration:none}html body a:hover{color:#00a3f5;text-decoration:none}html body img{max-width:100%}html body>p{margin-top:0;margin-bottom:16px;word-wrap:break-word}html body>ul,html body>ol{margin-bottom:16px}html body ul,html body ol{padding-left:2em}html body ul.no-list,html body ol.no-list{padding:0;list-style-type:none}html body ul ul,html body ul ol,html body ol ol,html body ol ul{margin-top:0;margin-bottom:0}html body li{margin-bottom:0}html body li.task-list-item{list-style:none}html body li>p{margin-top:0;margin-bottom:0}html body .task-list-item-checkbox{margin:0 .2em .25em -1.8em;vertical-align:middle}html body .task-list-item-checkbox:hover{cursor:pointer}html body blockquote{margin:16px 0;font-size:inherit;padding:0 15px;color:#5c5c5c;background-color:#f0f0f0;border-left:4px solid #d6d6d6}html body blockquote>:first-child{margin-top:0}html body blockquote>:last-child{margin-bottom:0}html body hr{height:4px;margin:32px 0;background-color:#d6d6d6;border:0 none}html body table{margin:10px 0 15px 0;border-collapse:collapse;border-spacing:0;display:block;width:100%;overflow:auto;word-break:normal;word-break:keep-all}html body table th{font-weight:bold;color:#000}html body table td,html body table th{border:1px solid #d6d6d6;padding:6px 13px}html body dl{padding:0}html body dl dt{padding:0;margin-top:16px;font-size:1em;font-style:italic;font-weight:bold}html body dl dd{padding:0 16px;margin-bottom:16px}html body code{font-family:Menlo,Monaco,Consolas,'Courier New',monospace;font-size:.85em !important;color:#000;background-color:#f0f0f0;border-radius:3px;padding:.2em 0}html body code::before,html body code::after{letter-spacing:-0.2em;content:\"\\00a0\"}html body pre>code{padding:0;margin:0;font-size:.85em !important;word-break:normal;white-space:pre;background:transparent;border:0}html body .highlight{margin-bottom:16px}html body .highlight pre,html body pre{padding:1em;overflow:auto;font-size:.85em !important;line-height:1.45;border:#d6d6d6;border-radius:3px}html body .highlight pre{margin-bottom:0;word-break:normal}html body pre code,html body pre tt{display:inline;max-width:initial;padding:0;margin:0;overflow:initial;line-height:inherit;word-wrap:normal;background-color:transparent;border:0}html body pre code:before,html body pre tt:before,html body pre code:after,html body pre tt:after{content:normal}html body p,html body blockquote,html body ul,html body ol,html body dl,html body pre{margin-top:0;margin-bottom:16px}html body kbd{color:#000;border:1px solid #d6d6d6;border-bottom:2px solid #c7c7c7;padding:2px 4px;background-color:#f0f0f0;border-radius:3px}@media print{html body{background-color:#fff}html body h1,html body h2,html body h3,html body h4,html body h5,html body h6{color:#000;page-break-after:avoid}html body blockquote{color:#5c5c5c}html body pre{page-break-inside:avoid}html body table{display:table}html body img{display:block;max-width:100%;max-height:100%}html body pre,html body code{word-wrap:break-word;white-space:pre}}.markdown-preview{width:100%;height:100%;box-sizing:border-box}.markdown-preview .pagebreak,.markdown-preview .newpage{page-break-before:always}.markdown-preview pre.line-numbers{position:relative;padding-left:3.8em;counter-reset:linenumber}.markdown-preview pre.line-numbers>code{position:relative}.markdown-preview pre.line-numbers .line-numbers-rows{position:absolute;pointer-events:none;top:1em;font-size:100%;left:0;width:3em;letter-spacing:-1px;border-right:1px solid #999;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none}.markdown-preview pre.line-numbers .line-numbers-rows>span{pointer-events:none;display:block;counter-increment:linenumber}.markdown-preview pre.line-numbers .line-numbers-rows>span:before{content:counter(linenumber);color:#999;display:block;padding-right:.8em;text-align:right}.markdown-preview .mathjax-exps .MathJax_Display{text-align:center !important}.markdown-preview:not([for=\"preview\"]) .code-chunk .btn-group{display:none}.markdown-preview:not([for=\"preview\"]) .code-chunk .status{display:none}.markdown-preview:not([for=\"preview\"]) .code-chunk .output-div{margin-bottom:16px}.markdown-preview .md-toc{padding:0}.markdown-preview .md-toc .md-toc-link-wrapper .md-toc-link{display:inline;padding:.25rem 0}.markdown-preview .md-toc .md-toc-link-wrapper .md-toc-link p,.markdown-preview .md-toc .md-toc-link-wrapper .md-toc-link div{display:inline}.markdown-preview .md-toc .md-toc-link-wrapper.highlighted .md-toc-link{font-weight:800}.scrollbar-style::-webkit-scrollbar{width:8px}.scrollbar-style::-webkit-scrollbar-track{border-radius:10px;background-color:transparent}.scrollbar-style::-webkit-scrollbar-thumb{border-radius:5px;background-color:rgba(150,150,150,0.66);border:4px solid rgba(150,150,150,0.66);background-clip:content-box}html body[for=\"html-export\"]:not([data-presentation-mode]){position:relative;width:100%;height:100%;top:0;left:0;margin:0;padding:0;overflow:auto}html body[for=\"html-export\"]:not([data-presentation-mode]) .markdown-preview{position:relative;top:0}@media screen and (min-width:914px){html body[for=\"html-export\"]:not([data-presentation-mode]) .markdown-preview{padding:2em calc(50% - 457px + 2em)}}@media screen and (max-width:914px){html body[for=\"html-export\"]:not([data-presentation-mode]) .markdown-preview{padding:2em}}@media screen and (max-width:450px){html body[for=\"html-export\"]:not([data-presentation-mode]) .markdown-preview{font-size:14px !important;padding:1em}}@media print{html body[for=\"html-export\"]:not([data-presentation-mode]) #sidebar-toc-btn{display:none}}html body[for=\"html-export\"]:not([data-presentation-mode]) #sidebar-toc-btn{position:fixed;bottom:8px;left:8px;font-size:28px;cursor:pointer;color:inherit;z-index:99;width:32px;text-align:center;opacity:.4}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] #sidebar-toc-btn{opacity:1}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc{position:fixed;top:0;left:0;width:300px;height:100%;padding:32px 0 48px 0;font-size:14px;box-shadow:0 0 4px rgba(150,150,150,0.33);box-sizing:border-box;overflow:auto;background-color:inherit}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc::-webkit-scrollbar{width:8px}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc::-webkit-scrollbar-track{border-radius:10px;background-color:transparent}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc::-webkit-scrollbar-thumb{border-radius:5px;background-color:rgba(150,150,150,0.66);border:4px solid rgba(150,150,150,0.66);background-clip:content-box}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc a{text-decoration:none}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc .md-toc{padding:0 16px}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc .md-toc .md-toc-link-wrapper .md-toc-link{display:inline;padding:.25rem 0}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc .md-toc .md-toc-link-wrapper .md-toc-link p,html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc .md-toc .md-toc-link-wrapper .md-toc-link div{display:inline}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .md-sidebar-toc .md-toc .md-toc-link-wrapper.highlighted .md-toc-link{font-weight:800}html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .markdown-preview{left:300px;width:calc(100% -  300px);padding:2em calc(50% - 457px -  300px/2);margin:0;box-sizing:border-box}@media screen and (max-width:1274px){html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .markdown-preview{padding:2em}}@media screen and (max-width:450px){html body[for=\"html-export\"]:not([data-presentation-mode])[html-show-sidebar-toc] .markdown-preview{width:100%}}html body[for=\"html-export\"]:not([data-presentation-mode]):not([html-show-sidebar-toc]) .markdown-preview{left:50%;transform:translateX(-50%)}html body[for=\"html-export\"]:not([data-presentation-mode]):not([html-show-sidebar-toc]) .md-sidebar-toc{display:none}\n" +
            "/* Please visit the URL below for more information: */\n" +
            "/*   https://shd101wyy.github.io/markdown-preview-enhanced/#/customize-css */\n" +
            "\n" +
            "      </style>";

    private  String js="<script>\n" +
            "\n" +
            "var sidebarTOCBtn = document.getElementById('sidebar-toc-btn')\n" +
            "sidebarTOCBtn.addEventListener('click', function(event) {\n" +
            "  event.stopPropagation()\n" +
            "  if (document.body.hasAttribute('html-show-sidebar-toc')) {\n" +
            "    document.body.removeAttribute('html-show-sidebar-toc')\n" +
            "  } else {\n" +
            "    document.body.setAttribute('html-show-sidebar-toc', true)\n" +
            "  }\n" +
            "})\n" +
            "</script>";
    private String htmltop="<!DOCTYPE html><html><head>\n" +
            "      <meta charset=\"utf-8\">\n" +
            "      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";

    private String htmlcenter="    </head>\n" +
            "    <body for=\"html-export\">\n" +
            "      <div class=\"mume markdown-preview  \">";
    private String htmldown=" </body></html>";
}
