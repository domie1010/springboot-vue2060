<template>
	<div class="diy_edit page_player_league_information" id="player_league_information_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','script_name') || $check_field('add','script_name') || $check_field('get','script_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								剧本名称:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_script_name" v-model="form['script_name']" placeholder="请输入剧本名称" v-if="(form['script_name'] && $check_field('set','script_name')) || (!form['script_name'] && $check_field('add','script_name'))"  :disabled="disabledObj['script_name_isDisabled']"/>
							<span v-else-if="$check_field('get','script_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','script_type') || $check_field('add','script_type') || $check_field('get','script_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								剧本类型:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_script_type" v-model="form['script_type']" placeholder="请输入剧本类型" v-if="(form['script_type'] && $check_field('set','script_type')) || (!form['script_type'] && $check_field('add','script_type'))"  :disabled="disabledObj['script_type_isDisabled']"/>
							<span v-else-if="$check_field('get','script_type')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','store_address') || $check_field('add','store_address') || $check_field('get','store_address')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								店铺地址:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_store_address" v-model="form['store_address']" placeholder="请输入店铺地址" v-if="(form['store_address'] && $check_field('set','store_address')) || (!form['store_address'] && $check_field('add','store_address'))"  :disabled="disabledObj['store_address_isDisabled']"/>
							<span v-else-if="$check_field('get','store_address')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','publishing_users') || $check_field('add','publishing_users') || $check_field('get','publishing_users')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								发布用户:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_publishing_users" :disabled="disabledObj['publishing_users_isDisabled']" v-model="form['publishing_users']" v-if="(form['publishing_users'] && $check_field('set','publishing_users')) || (!form['publishing_users'] && $check_field('add','publishing_users'))" >
								<option v-for="o in list_user_publishing_users" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','publishing_users')">{{ form['publishing_users'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','group_user') || $check_field('add','group_user') || $check_field('get','group_user')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								拼团用户:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_group_user" :disabled="disabledObj['group_user_isDisabled']" v-model="form['group_user']" v-if="(form['group_user'] && $check_field('set','group_user')) || (!form['group_user'] && $check_field('add','group_user'))" >
								<option v-for="o in list_user_group_user" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','group_user')">{{ form['group_user'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','number_of_groups') || $check_field('add','number_of_groups') || $check_field('get','number_of_groups')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								拼团数量:
							</span>
						</div>
								<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_number_of_groups" v-model="form['number_of_groups']" v-if="(form['number_of_groups'] && $check_field('set','number_of_groups')) || (!form['number_of_groups'] && $check_field('add','number_of_groups'))" >
								<option v-for="o in list_number_of_groups" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','number_of_groups')">{{ form['number_of_groups'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','group_time') || $check_field('add','group_time') || $check_field('get','group_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								拼团时间:
							</span>
						</div>
								<!-- 日长 -->
						<div class="diy_field diy_datetime">
							<input type="datetime-local" :disabled="disabledObj['group_time_isDisabled']" id="form_group_time" v-model="form['group_time']" placeholder="请输入拼团时间" v-if="(form['group_time'] && $check_field('set','group_time')) || (!form['group_time'] && $check_field('add','group_time'))" />
							<span v-else-if="$check_field('get','group_time')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
	




				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/player_league_information/get_obj?",
				url_add: "~/api/player_league_information/add?",
				url_set: "~/api/player_league_information/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"script_name": "",
							"script_type": "",
							"store_address": "",
							"publishing_users": 0,
							"group_user": 0,
							"number_of_groups": "",
							"group_time": "",
						"player_league_information_id": 0,
				},

				obj: {
						"script_name":  '', // 剧本名称
							"script_type":  '', // 剧本类型
							"store_address":  '', // 店铺地址
							"publishing_users": 0, // 发布用户
							"group_user": 0, // 拼团用户
							"number_of_groups":  '', // 拼团数量
							"group_time": new Date().getTime(),
						"player_league_information_id": 0,
				},

				// 表单字段
				form: {
						"script_name":  '', // 剧本名称
							"script_type":  '', // 剧本类型
							"store_address":  '', // 店铺地址
							"publishing_users": 0, // 发布用户
							"group_user": 0, // 拼团用户
							"number_of_groups":  '', // 拼团数量
							"group_time": new Date().getTime(),
						"player_league_information_id": 0,
				},
				disabledObj:{
						"script_name_isDisabled": false,
							"script_type_isDisabled": false,
							"store_address_isDisabled": false,
							"publishing_users_isDisabled": false,
							"group_user_isDisabled": false,
							"number_of_groups_isDisabled": false,
							"group_time_isDisabled": false,
					},

												// 用户列表
				list_user_publishing_users: [],
							// 用户列表
				list_user_group_user: [],
						// 拼团数量选项列表
				list_number_of_groups: ['1'],
				
				// ID字段
				field: "player_league_information_id",

			}
		},
		methods: {
			
				
				
						/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_publishing_users() {
				// if(this.user_group !== "管理员" && this.form["publishing_users"] === 0) {
				//     this.form["publishing_users"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=普通用户");
				if(json.result && json.result.list){
					this.list_user_publishing_users = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
		
						/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_group_user() {
				// if(this.user_group !== "管理员" && this.form["group_user"] === 0) {
				//     this.form["group_user"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=普通用户");
				if(json.result && json.result.list){
					this.list_user_group_user = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
					async get_user_session_group_user(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["group_user"] = user_id
								_this.disabledObj['group_user' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "group_user") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
				
				
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/player_league_information/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
													        if (JSON.stringify(this.form["group_time"]).indexOf("-")===-1) {
          this.form["group_time"] = this.$toTime(parseInt(this.form["group_time"]), "yyyy-MM-ddThh:mm")
        }
		
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }
				if(func){
					func(json);
				}
			},

		},
		created() {
															this.get_list_user_publishing_users();
						this.get_user_session_group_user();
					this.get_list_user_group_user();
									},
	}
</script>

<style>




</style>
