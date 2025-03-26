<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','script_name') || $check_field('add','script_name') || $check_field('set','script_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本名称" prop="script_name">
												<el-input id="script_name" v-model="form['script_name']" placeholder="请输入剧本名称"
							  v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','script_name')) || (!form['player_team_id'] && $check_field('add','script_name'))" :disabled="disabledObj['script_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_name')">{{form['script_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_type') || $check_field('add','script_type') || $check_field('set','script_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本类型" prop="script_type">
												<el-input id="script_type" v-model="form['script_type']" placeholder="请输入剧本类型"
							  v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','script_type')) || (!form['player_team_id'] && $check_field('add','script_type'))" :disabled="disabledObj['script_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_type')">{{form['script_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','store_address') || $check_field('add','store_address') || $check_field('set','store_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺地址" prop="store_address">
												<el-input id="store_address" v-model="form['store_address']" placeholder="请输入店铺地址"
							  v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','store_address')) || (!form['player_team_id'] && $check_field('add','store_address'))" :disabled="disabledObj['store_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_address')">{{form['store_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','publishing_users') || $check_field('add','publishing_users') || $check_field('set','publishing_users')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="发布用户" prop="publishing_users">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_publishing_users(form['publishing_users']) }}
							<!--<el-input id="business_name" v-model="form['publishing_users']" placeholder="请输入发布用户"-->
							<!--v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','publishing_users')) || (!form['player_team_id'] && $check_field('add','publishing_users'))" :disabled="disabledObj['publishing_users_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','publishing_users')">{{form['publishing_users']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','publishing_users')) || (!form['player_team_id'] && $check_field('add','publishing_users'))" id="publishing_users" v-model="form['publishing_users']" :disabled="disabledObj['publishing_users_isDisabled']">
								<el-option v-for="o in list_user_publishing_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','publishing_users')" id="publishing_users" v-model="form['publishing_users']" :disabled="true">
								<el-option v-for="o in list_user_publishing_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="publishing_users" v-model="form['publishing_users']" :disabled="disabledObj['publishing_users_isDisabled']">
							<el-option v-for="o in list_user_publishing_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_participants') || $check_field('add','number_of_participants') || $check_field('set','number_of_participants')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="拼团人数" prop="number_of_participants">
								<el-input-number id="number_of_participants" v-model.number="form['number_of_participants']"
						v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','number_of_participants')) || (!form['player_team_id'] && $check_field('add','number_of_participants'))" :disabled="disabledObj['number_of_participants_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_participants')">{{form['number_of_participants']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_people_remaining') || $check_field('add','number_of_people_remaining') || $check_field('set','number_of_people_remaining')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剩余人数" prop="number_of_people_remaining">
								<el-input-number id="number_of_people_remaining" v-model.number="form['number_of_people_remaining']"
						v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','number_of_people_remaining')) || (!form['player_team_id'] && $check_field('add','number_of_people_remaining'))" :disabled="disabledObj['number_of_people_remaining_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_people_remaining')">{{form['number_of_people_remaining']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','cover_photo') || $check_field('add','cover_photo') || $check_field('set','cover_photo')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="封面图片" prop="cover_photo">
								<el-upload :disabled="disabledObj['cover_photo_isDisabled']" id="cover_photo" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover_photo"
						:show-file-list="false" v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','cover_photo')) || (!form['player_team_id'] && $check_field('add','cover_photo'))">
						<img v-if="form['cover_photo']" :src="$fullUrl(form['cover_photo'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','cover_photo')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['cover_photo'])" :preview-src-list="[$fullUrl(form['cover_photo'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_introduction') || $check_field('add','script_introduction') || $check_field('set','script_introduction')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="剧本简介" prop="script_introduction">
					<quill-editor v-model.number="form['script_introduction']"
						v-if="user_group === '管理员' || (form['player_team_id'] && $check_field('set','script_introduction')) || (!form['player_team_id'] && $check_field('add','script_introduction')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','script_introduction')" v-html="form['script_introduction']"></div>
				</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "player_team_id",
				url_add: "~/api/player_team/add?",
				url_set: "~/api/player_team/set?",
				url_get_obj: "~/api/player_team/get_obj?",
				url_upload: "~/api/player_team/upload?",

				query: {
					"player_team_id": 0,
				},

				form: {
								"script_name":  '', // 剧本名称
										"script_type":  '', // 剧本类型
										"store_address":  '', // 店铺地址
										"publishing_users": 0, // 发布用户
										"number_of_participants":  0, // 拼团人数
										"number_of_people_remaining":  0, // 剩余人数
										"cover_photo":  '', // 封面图片
										"script_introduction":  '', // 剧本简介
											"player_team_id": 0, // ID
						
				},
				disabledObj:{
								"script_name_isDisabled": false,
										"script_type_isDisabled": false,
										"store_address_isDisabled": false,
										"publishing_users_isDisabled": false,
					          			"number_of_participants_isDisabled": false,
					          			"number_of_people_remaining_isDisabled": false,
										"cover_photo_isDisabled": false,
										"script_introduction_isDisabled": false,
										},

	
		
		
		
					// 用户列表
				list_user_publishing_users: [],
						// 用户组
				group_user_publishing_users: "",
				
		
		
		
	
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
			 * 获取普通用户用户组
			 */
			async get_group_user_publishing_users() {
							this.form["publishing_users"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					this.group_user_publishing_users = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_publishing_users(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_publishing_users.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["publishing_users"] = id
									_this.disabledObj['publishing_users' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "publishing_users") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_publishing_users(id){
				var obj = this.list_user_publishing_users.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
						/**
			 * 上传封面图片
			 * @param {Object} param 图片参数
			 */
			upload_cover_photo(param){
						this.uploadFile(param.file, "cover_photo");
					},
	
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																	
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																								

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																														return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/player_team/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/player_team/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/player_team/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/player_team/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/player_team/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
											this.get_list_user_publishing_users();
					this.get_group_user_publishing_users();
													},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
