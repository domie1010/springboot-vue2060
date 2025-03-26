<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="剧本资讯"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_user_name"
				title="普通用户用户姓名"
				source_table="ordinary_users"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/quality_store/list', 'get')"
				:list="result_quality_store_store_name"
				title="优质店铺店铺名称"
				source_table="quality_store"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/quality_store/list', 'get')"
				:list="result_quality_store_store_address"
				title="优质店铺店铺地址"
				source_table="quality_store"
			  ></list_result_search>
																					  <list_result_search
				v-if="$check_action('/script_information/list', 'get')"
				:list="result_script_information_script_name"
				title="剧本信息剧本名称"
				source_table="script_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/script_information/list', 'get')"
				:list="result_script_information_script_rating"
				title="剧本信息剧本评分"
				source_table="script_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/script_information/list', 'get')"
				:list="result_script_information_script_ranking"
				title="剧本信息剧本排行"
				source_table="script_information"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/purchase_information/list', 'get')"
				:list="result_purchase_information_script_name"
				title="购买信息剧本名称"
				source_table="purchase_information"
			  ></list_result_search>
																	  <list_result_search
				v-if="$check_action('/purchase_information/list', 'get')"
				:list="result_purchase_information_user_name"
				title="购买信息用户姓名"
				source_table="purchase_information"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/script_collage/list', 'get')"
				:list="result_script_collage_script_name"
				title="剧本拼团剧本名称"
				source_table="script_collage"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/script_collage/list', 'get')"
				:list="result_script_collage_script_type"
				title="剧本拼团剧本类型"
				source_table="script_collage"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/player_team/list', 'get')"
				:list="result_player_team_script_name"
				title="玩家拼团剧本名称"
				source_table="player_team"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/player_team/list', 'get')"
				:list="result_player_team_script_type"
				title="玩家拼团剧本类型"
				source_table="player_team"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/script_collaboration_information/list', 'get')"
				:list="result_script_collaboration_information_script_name"
				title="剧本拼团信息剧本名称"
				source_table="script_collaboration_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/script_collaboration_information/list', 'get')"
				:list="result_script_collaboration_information_script_type"
				title="剧本拼团信息剧本类型"
				source_table="script_collaboration_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/script_collaboration_information/list', 'get')"
				:list="result_script_collaboration_information_user_name"
				title="剧本拼团信息用户姓名"
				source_table="script_collaboration_information"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/player_league_information/list', 'get')"
				:list="result_player_league_information_script_name"
				title="玩家拼团信息剧本名称"
				source_table="player_league_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/player_league_information/list', 'get')"
				:list="result_player_league_information_script_type"
				title="玩家拼团信息剧本类型"
				source_table="player_league_information"
			  ></list_result_search>
																					</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
						"result_ordinary_users_user_name":[],
															"result_quality_store_store_name":[],
								"result_quality_store_store_address":[],
																					"result_script_information_script_name":[],
														"result_script_information_script_rating":[],
								"result_script_information_script_ranking":[],
																		"result_purchase_information_script_name":[],
																	"result_purchase_information_user_name":[],
															"result_script_collage_script_name":[],
								"result_script_collage_script_type":[],
																											"result_player_team_script_name":[],
								"result_player_team_script_type":[],
																											"result_script_collaboration_information_script_name":[],
								"result_script_collaboration_information_script_type":[],
														"result_script_collaboration_information_user_name":[],
															"result_player_league_information_script_name":[],
								"result_player_league_information_script_type":[],
																			};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取user_name
	 */
	get_ordinary_users_user_name(){
		this.$get("~/api/ordinary_users/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_user_name = json.result.list;
			result_ordinary_users_user_name.map(o => o.title = o['user_name'])
	  			this.result_ordinary_users_user_name = result_ordinary_users_user_name
		 	}
		});
	},
													/**
	 * 获取store_name
	 */
	get_quality_store_store_name(){
		this.$get("~/api/quality_store/get_list?like=0", { page: 1, size: 10, "store_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_quality_store_store_name = json.result.list;
			result_quality_store_store_name.map(o => o.title = o['store_name'])
	  			this.result_quality_store_store_name = result_quality_store_store_name
		 	}
		});
	},
						/**
	 * 获取store_address
	 */
	get_quality_store_store_address(){
		this.$get("~/api/quality_store/get_list?like=0", { page: 1, size: 10, "store_address": this.query.word }, (json) => {
		  if (json.result) {
			var result_quality_store_store_address = json.result.list;
			result_quality_store_store_address.map(o => o.title = o['store_address'])
	  			this.result_quality_store_store_address = result_quality_store_store_address
		 	}
		});
	},
																			/**
	 * 获取script_name
	 */
	get_script_information_script_name(){
		this.$get("~/api/script_information/get_list?like=0", { page: 1, size: 10, "script_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_information_script_name = json.result.list;
			result_script_information_script_name.map(o => o.title = o['script_name'])
	  			this.result_script_information_script_name = result_script_information_script_name
		 	}
		});
	},
												/**
	 * 获取script_rating
	 */
	get_script_information_script_rating(){
		this.$get("~/api/script_information/get_list?like=0", { page: 1, size: 10, "script_rating": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_information_script_rating = json.result.list;
			result_script_information_script_rating.map(o => o.title = o['script_rating'])
	  			this.result_script_information_script_rating = result_script_information_script_rating
		 	}
		});
	},
						/**
	 * 获取script_ranking
	 */
	get_script_information_script_ranking(){
		this.$get("~/api/script_information/get_list?like=0", { page: 1, size: 10, "script_ranking": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_information_script_ranking = json.result.list;
			result_script_information_script_ranking.map(o => o.title = o['script_ranking'])
	  			this.result_script_information_script_ranking = result_script_information_script_ranking
		 	}
		});
	},
																/**
	 * 获取script_name
	 */
	get_purchase_information_script_name(){
		this.$get("~/api/purchase_information/get_list?like=0", { page: 1, size: 10, "script_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_purchase_information_script_name = json.result.list;
			result_purchase_information_script_name.map(o => o.title = o['script_name'])
	  			this.result_purchase_information_script_name = result_purchase_information_script_name
		 	}
		});
	},
															/**
	 * 获取user_name
	 */
	get_purchase_information_user_name(){
		this.$get("~/api/purchase_information/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_purchase_information_user_name = json.result.list;
			result_purchase_information_user_name.map(o => o.title = o['user_name'])
	  			this.result_purchase_information_user_name = result_purchase_information_user_name
		 	}
		});
	},
													/**
	 * 获取script_name
	 */
	get_script_collage_script_name(){
		this.$get("~/api/script_collage/get_list?like=0", { page: 1, size: 10, "script_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_collage_script_name = json.result.list;
			result_script_collage_script_name.map(o => o.title = o['script_name'])
	  			this.result_script_collage_script_name = result_script_collage_script_name
		 	}
		});
	},
						/**
	 * 获取script_type
	 */
	get_script_collage_script_type(){
		this.$get("~/api/script_collage/get_list?like=0", { page: 1, size: 10, "script_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_collage_script_type = json.result.list;
			result_script_collage_script_type.map(o => o.title = o['script_type'])
	  			this.result_script_collage_script_type = result_script_collage_script_type
		 	}
		});
	},
																									/**
	 * 获取script_name
	 */
	get_player_team_script_name(){
		this.$get("~/api/player_team/get_list?like=0", { page: 1, size: 10, "script_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_player_team_script_name = json.result.list;
			result_player_team_script_name.map(o => o.title = o['script_name'])
	  			this.result_player_team_script_name = result_player_team_script_name
		 	}
		});
	},
						/**
	 * 获取script_type
	 */
	get_player_team_script_type(){
		this.$get("~/api/player_team/get_list?like=0", { page: 1, size: 10, "script_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_player_team_script_type = json.result.list;
			result_player_team_script_type.map(o => o.title = o['script_type'])
	  			this.result_player_team_script_type = result_player_team_script_type
		 	}
		});
	},
																									/**
	 * 获取script_name
	 */
	get_script_collaboration_information_script_name(){
		this.$get("~/api/script_collaboration_information/get_list?like=0", { page: 1, size: 10, "script_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_collaboration_information_script_name = json.result.list;
			result_script_collaboration_information_script_name.map(o => o.title = o['script_name'])
	  			this.result_script_collaboration_information_script_name = result_script_collaboration_information_script_name
		 	}
		});
	},
						/**
	 * 获取script_type
	 */
	get_script_collaboration_information_script_type(){
		this.$get("~/api/script_collaboration_information/get_list?like=0", { page: 1, size: 10, "script_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_collaboration_information_script_type = json.result.list;
			result_script_collaboration_information_script_type.map(o => o.title = o['script_type'])
	  			this.result_script_collaboration_information_script_type = result_script_collaboration_information_script_type
		 	}
		});
	},
												/**
	 * 获取user_name
	 */
	get_script_collaboration_information_user_name(){
		this.$get("~/api/script_collaboration_information/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_script_collaboration_information_user_name = json.result.list;
			result_script_collaboration_information_user_name.map(o => o.title = o['user_name'])
	  			this.result_script_collaboration_information_user_name = result_script_collaboration_information_user_name
		 	}
		});
	},
													/**
	 * 获取script_name
	 */
	get_player_league_information_script_name(){
		this.$get("~/api/player_league_information/get_list?like=0", { page: 1, size: 10, "script_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_player_league_information_script_name = json.result.list;
			result_player_league_information_script_name.map(o => o.title = o['script_name'])
	  			this.result_player_league_information_script_name = result_player_league_information_script_name
		 	}
		});
	},
						/**
	 * 获取script_type
	 */
	get_player_league_information_script_type(){
		this.$get("~/api/player_league_information/get_list?like=0", { page: 1, size: 10, "script_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_player_league_information_script_type = json.result.list;
			result_player_league_information_script_type.map(o => o.title = o['script_type'])
	  			this.result_player_league_information_script_type = result_player_league_information_script_type
		 	}
		});
	},
																		
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
					this.get_ordinary_users_user_name();
														this.get_quality_store_store_name();
							this.get_quality_store_store_address();
																				this.get_script_information_script_name();
													this.get_script_information_script_rating();
							this.get_script_information_script_ranking();
																	this.get_purchase_information_script_name();
																this.get_purchase_information_user_name();
														this.get_script_collage_script_name();
							this.get_script_collage_script_type();
																										this.get_player_team_script_name();
							this.get_player_team_script_type();
																										this.get_script_collaboration_information_script_name();
							this.get_script_collaboration_information_script_type();
													this.get_script_collaboration_information_user_name();
														this.get_player_league_information_script_name();
							this.get_player_league_information_script_type();
																		  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
				  this.get_ordinary_users_user_name();
													  this.get_quality_store_store_name();
						  this.get_quality_store_store_address();
																			  this.get_script_information_script_name();
												  this.get_script_information_script_rating();
						  this.get_script_information_script_ranking();
																  this.get_purchase_information_script_name();
															  this.get_purchase_information_user_name();
													  this.get_script_collage_script_name();
						  this.get_script_collage_script_type();
																									  this.get_player_team_script_name();
						  this.get_player_team_script_type();
																									  this.get_script_collaboration_information_script_name();
						  this.get_script_collaboration_information_script_type();
												  this.get_script_collaboration_information_user_name();
													  this.get_player_league_information_script_name();
						  this.get_player_league_information_script_type();
																			},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
