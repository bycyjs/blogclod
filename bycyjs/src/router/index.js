import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'layout',
      component: () => import('../layout/Layout.vue'),
      redirect: '/home',
      children: [
        {
          path: '/home',
          name: 'home',
          component: HomeView
        }, {
          path: "/function",
          name: "function",
          component: () => import('../function/Function.vue')
        },{
          path: "/webboard",
          name: "webboard",
          component: () => import('../views/WebBoard.vue')
        }, {
          path: '/tab',
          name: 'tab',
          component: () => import('../views/Tab.vue')
        },{
          path: '/pigeonhole',
          name: 'pigeonhole',
          component: () => import('../views/Pigeonhole.vue')
        },{
          path: '/concerning',
          name: "concerning",
          component: () => import('../views/concerning.vue')
        },{
          path:'/login',
          name:"login",
          component:()=>import('../function/functionalgroup/LogIn.vue')
        },{
          path:'/enroll',
          name:"enroll",
          component:()=>import('../function/functionalgroup/Enroll.vue')
        },{
          path:'/filedownload',
          name:"filedownload",
          component:()=>import('../function/functionalgroup/FileDownload.vue')
        },{
          path:'/upload',
          name:"upload",
          component:()=>import('../function/functionalgroup/Upload.vue')
        },{
          path:'/addmailbox',
          name:"addmailbox",
          component:()=>import('../function/functionalgroup/AddMailbox.vue')
        },{
          path:'/sendmailboxcode',
          name:"sendmailboxcode",
          component:()=>import('../function/functionalgroup/SendMailboxCode.vue')
        },{
          path:'/mdupload',
          name:"mdupload",
          component:()=>import('../function/functionalgroup/MdUpload.vue')
        },{
          path:'/note',
          name:"note",
          component:()=>import('../function/functionalgroup/Note.vue')
        },{
          path:'/phonnav',
          name:"phonnav",
          component:()=>import('../views/PhoneNav.vue')
        }
      ]
    },{
      path:'/weixing',
      name:"weixing",
      component:()=>import('../currency/Weixing.vue')
    }
   
  ]
})

export default router
