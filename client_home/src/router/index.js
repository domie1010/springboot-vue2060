import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue'
import login from '../views/account/login.vue';

Vue.use(VueRouter)

const routes = [
	// 主页ss
	{
		path: '/',
		name: 'index',
		component: index
	},
	// 登录
	{
		path: '/account/login',
		name: 'login',
		component: login
	},
	// 忘记密码
	{
		path: '/account/forgot',
		name: 'forgot',
		component: () => import('../views/account/forgot.vue')
	},
	// 注册账号
	{
		path: '/account/register',
		name: 'register',
		component: () => import('../views/account/register.vue')
	},
	// 媒体图片
	{
		path: '/media/image',
		name: 'media_image',
		component: () => import('../views/media/image.vue')
	},
	// 音乐
	{
		path: '/media/music',
		name: 'media_music',
		component: () => import('../views/media/music.vue')
	},
	// 媒体视频
	{
		path: '/media/video',
		name: 'media_video',
		component: () => import('../views/media/video.vue')
	},
	// 文章路由
	{
		path: '/article/list',
		name: 'article_list',
		component: () => import('../views/article/list.vue')
	},
	{
		path: '/article/details',
		name: 'article_details',
		component: () => import('../views/article/details.vue')
	},
	// 浏览网站
	// 收藏路由
	{
		path: '/user/collect',
		name: 'collect_list',
		component: () => import('../views/user/collect.vue')
	},






	// 公告路由
	{
		path: '/notice/list',
		name: 'notice_list',
		component: () => import('../views/notice/list.vue')
	},
	{
		path: '/notice/details',
		name: 'notice_details',
		component: () => import('../views/notice/details.vue')
	},
	
	
		
		// 优质店铺列表路由
	{
		path: '/quality_store/list',
		name: '/quality_store_list',
		component: () => import('../views/quality_store/list.vue')
	},
	
		// 优质店铺详情路由
	{
		path: '/quality_store/details',
		name: '/quality_store_details',
		component: () => import('../views/quality_store/details.vue')
	},
		
		// 剧本信息列表路由
	{
		path: '/script_information/list',
		name: '/script_information_list',
		component: () => import('../views/script_information/list.vue')
	},
	
		// 剧本信息详情路由
	{
		path: '/script_information/details',
		name: '/script_information_details',
		component: () => import('../views/script_information/details.vue')
	},
			// 购买信息添加路由
	{
		path: '/purchase_information/edit',
		name: '/purchase_information_edit',
		component: () => import('../views/purchase_information/edit.vue')
	},
	
	
		
		// 剧本拼团列表路由
	{
		path: '/script_collage/list',
		name: '/script_collage_list',
		component: () => import('../views/script_collage/list.vue')
	},
	
		// 剧本拼团详情路由
	{
		path: '/script_collage/details',
		name: '/script_collage_details',
		component: () => import('../views/script_collage/details.vue')
	},
		
		// 玩家拼团列表路由
	{
		path: '/player_team/list',
		name: '/player_team_list',
		component: () => import('../views/player_team/list.vue')
	},
	
		// 玩家拼团详情路由
	{
		path: '/player_team/details',
		name: '/player_team_details',
		component: () => import('../views/player_team/details.vue')
	},
			// 剧本拼团信息添加路由
	{
		path: '/script_collaboration_information/edit',
		name: '/script_collaboration_information_edit',
		component: () => import('../views/script_collaboration_information/edit.vue')
	},
	
	
			// 玩家拼团信息添加路由
	{
		path: '/player_league_information/edit',
		name: '/player_league_information_edit',
		component: () => import('../views/player_league_information/edit.vue')
	},
	
	
	
	// 用户路由
	{
		path: '/user/index',
		name: 'user_index',
		component: () => import('../views/user/index.vue')
	},
	// 基本信息
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue')
	},
	// 找回密码
	{
		path: '/user/password',
		name: 'user_password',
		component: () => import('../views/user/password.vue')
	},

	// 搜索
	{
		path: '/search',
		name: 'search',
		component: () => import('../views/search/index.vue')
	},
	// 局部搜索
	{
		path: '/search/details',
		name: 'search_details',
		component: () => import('../views/search/details.vue')
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.afterEach((to, from, next) => {
	let title = "剧本杀服务平台-home";
	document.title = title;
	document.logo = "剧本杀服务平台"
})

export default router
