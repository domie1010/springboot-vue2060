import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告消息列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告消息详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 普通用户路由
	{
		path: '/ordinary_users/table',
		name: 'ordinary_users_table',
		component: () => import('../views/ordinary_users/table.vue'),
		meta: {
			index: 0,
			title: '普通用户列表'
		}
	},
	{
		path: '/ordinary_users/view',
		name: 'ordinary_users_view',
		component: () => import('../views/ordinary_users/view.vue'),
		meta: {
			index: 0,
			title: '普通用户详情'
		}
	},
	// 优质店铺路由
	{
		path: '/quality_store/table',
		name: 'quality_store_table',
		component: () => import('../views/quality_store/table.vue'),
		meta: {
			index: 0,
			title: '优质店铺列表'
		}
	},
	{
		path: '/quality_store/view',
		name: 'quality_store_view',
		component: () => import('../views/quality_store/view.vue'),
		meta: {
			index: 0,
			title: '优质店铺详情'
		}
	},
	// 剧本信息路由
	{
		path: '/script_information/table',
		name: 'script_information_table',
		component: () => import('../views/script_information/table.vue'),
		meta: {
			index: 0,
			title: '剧本信息列表'
		}
	},
	{
		path: '/script_information/view',
		name: 'script_information_view',
		component: () => import('../views/script_information/view.vue'),
		meta: {
			index: 0,
			title: '剧本信息详情'
		}
	},
	// 购买信息路由
	{
		path: '/purchase_information/table',
		name: 'purchase_information_table',
		component: () => import('../views/purchase_information/table.vue'),
		meta: {
			index: 0,
			title: '购买信息列表'
		}
	},
	{
		path: '/purchase_information/view',
		name: 'purchase_information_view',
		component: () => import('../views/purchase_information/view.vue'),
		meta: {
			index: 0,
			title: '购买信息详情'
		}
	},
	// 剧本拼团路由
	{
		path: '/script_collage/table',
		name: 'script_collage_table',
		component: () => import('../views/script_collage/table.vue'),
		meta: {
			index: 0,
			title: '剧本拼团列表'
		}
	},
	{
		path: '/script_collage/view',
		name: 'script_collage_view',
		component: () => import('../views/script_collage/view.vue'),
		meta: {
			index: 0,
			title: '剧本拼团详情'
		}
	},
	// 玩家拼团路由
	{
		path: '/player_team/table',
		name: 'player_team_table',
		component: () => import('../views/player_team/table.vue'),
		meta: {
			index: 0,
			title: '玩家拼团列表'
		}
	},
	{
		path: '/player_team/view',
		name: 'player_team_view',
		component: () => import('../views/player_team/view.vue'),
		meta: {
			index: 0,
			title: '玩家拼团详情'
		}
	},
	// 剧本拼团信息路由
	{
		path: '/script_collaboration_information/table',
		name: 'script_collaboration_information_table',
		component: () => import('../views/script_collaboration_information/table.vue'),
		meta: {
			index: 0,
			title: '剧本拼团信息列表'
		}
	},
	{
		path: '/script_collaboration_information/view',
		name: 'script_collaboration_information_view',
		component: () => import('../views/script_collaboration_information/view.vue'),
		meta: {
			index: 0,
			title: '剧本拼团信息详情'
		}
	},
	// 玩家拼团信息路由
	{
		path: '/player_league_information/table',
		name: 'player_league_information_table',
		component: () => import('../views/player_league_information/table.vue'),
		meta: {
			index: 0,
			title: '玩家拼团信息列表'
		}
	},
	{
		path: '/player_league_information/view',
		name: 'player_league_information_view',
		component: () => import('../views/player_league_information/view.vue'),
		meta: {
			index: 0,
			title: '玩家拼团信息详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "剧本杀服务平台-admin";
	document.title = title;
})

export default router
