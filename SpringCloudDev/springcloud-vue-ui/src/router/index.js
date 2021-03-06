import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [{
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [{
      path: '/redirect/:path*',
      component: () => import('@/views/redirect/index')
    }]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'dashboard',
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index'),
      name: 'Dashboard',
      meta: {
        title: 'dashboard',
        icon: 'dashboard',
        affix: true
      }
    }]
  },
  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    children: [{
      path: 'index',
      component: () => import('@/views/profile/index'),
      name: 'Profile',
      meta: {
        title: 'profile',
        icon: 'user',
        noCache: true
      }
    }]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  // 404 page must be placed at the end !!!
  {
    path: '*',
    redirect: '/404',
    hidden: true
  }
]
export const componentMap = {
  notice: () => import('@/views/desk/notice/index'),
  user: () => import('@/views/system/user/index'),
  dept: () => import('@/views/system/dept/index'),
  dict: () => import('@/views/system/dict/index'),
  menu: () => import('@/views/system/menu/index'),
  role: () => import('@/views/permission/role/index'),
  datarole: () => import('@/views/permission/datarole/index'),
  interfacerole: () => import('@/views/permission/interfacerole/index'),
  params: () => import('@/views/system/param/index'),
  tenant: () => import('@/views/system/tenant/index'),
  client: () => import('@/views/system/client/index'),
  log: () => import('@/views/monitor/log/index'),
  log_usual: () => import('@/views/monitor/log/usual/index'),
  log_api: () => import('@/views/monitor/log/api/index'),
  log_error: () => import('@/views/monitor/log/error/index'),
  codes: () => import('@/views/tool/code/index'),
  datasource: () => import('@/views/tool/datasource/index'),
  dbinstance: () => import('@/views/tool/dbinstance/index'),
  tableinfo: () => import('@/views/tool/tableinfo/index'),
  areas: () => import('@/views/system/area/index'),
  activity_manager: () => import('@/views/integral/marketingact/index'),
  activity_audit: () => import('@/views/integral/actprm/index'),
  integral_balance: () => import('@/views/integral/actprm/index'),
  trade_detail: () => import('@/views/integral/actprm/index'),
  integral_adjust: () => import('@/views/integral/actprm/index'),
  integral_adjust_aduit: () => import('@/views/integral/actprm/index'),
  integral_terminal: () => import('@/views/integral/actprm/index'),
  integral_terminal_aduit: () => import('@/views/integral/actprm/index'),
  mock_website: () => import('@/views/mock/mockwebsite/index'),
  mock_interface: () => import('@/views/mock/mockhttp/index')
}
const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({
    y: 0
  }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
