<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','script_name') || $check_field('add','script_name') || $check_field('set','script_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本名称" prop="script_name">
												<el-input id="script_name" v-model="form['script_name']" placeholder="请输入剧本名称"
							  v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','script_name')) || (!form['script_collage_id'] && $check_field('add','script_name'))" :disabled="disabledObj['script_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_name')">{{form['script_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_type') || $check_field('add','script_type') || $check_field('set','script_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本类型" prop="script_type">
												<el-input id="script_type" v-model="form['script_type']" placeholder="请输入剧本类型"
							  v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','script_type')) || (!form['script_collage_id'] && $check_field('add','script_type'))" :disabled="disabledObj['script_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_type')">{{form['script_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_price') || $check_field('add','script_price') || $check_field('set','script_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本价格" prop="script_price">
								<el-input-number id="script_price" v-model.number="form['script_price']"
						v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','script_price')) || (!form['script_collage_id'] && $check_field('add','script_price'))" :disabled="disabledObj['script_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','script_price')">{{form['script_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_participants') || $check_field('add','number_of_participants') || $check_field('set','number_of_participants')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="拼团人数" prop="number_of_participants">
								<el-input-number id="number_of_participants" v-model.number="form['number_of_participants']"
						v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','number_of_participants')) || (!form['script_collage_id'] && $check_field('add','number_of_participants'))" :disabled="disabledObj['number_of_participants_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_participants')">{{form['number_of_participants']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_people_remaining') || $check_field('add','number_of_people_remaining') || $check_field('set','number_of_people_remaining')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剩余人数" prop="number_of_people_remaining">
								<el-input-number id="number_of_people_remaining" v-model.number="form['number_of_people_remaining']"
						v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','number_of_people_remaining')) || (!form['script_collage_id'] && $check_field('add','number_of_people_remaining'))" :disabled="disabledObj['number_of_people_remaining_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_people_remaining')">{{form['number_of_people_remaining']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','instructions_for_teamwork') || $check_field('add','instructions_for_teamwork') || $check_field('set','instructions_for_teamwork')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="拼团须知" prop="instructions_for_teamwork">
								<el-input type="textarea" id="instructions_for_teamwork" v-model="form['instructions_for_teamwork']" placeholder="请输入拼团须知"
						v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','instructions_for_teamwork')) || (!form['script_collage_id'] && $check_field('add','instructions_for_teamwork'))" :disabled="disabledObj['instructions_for_teamwork_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','instructions_for_teamwork')">{{form['instructions_for_teamwork']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','cover_photo') || $check_field('add','cover_photo') || $check_field('set','cover_photo')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="封面图片" prop="cover_photo">
								<el-upload :disabled="disabledObj['cover_photo_isDisabled']" id="cover_photo" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover_photo"
						:show-file-list="false" v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','cover_photo')) || (!form['script_collage_id'] && $check_field('add','cover_photo'))">
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
						v-if="user_group === '管理员' || (form['script_collage_id'] && $check_field('set','script_introduction')) || (!form['script_collage_id'] && $check_field('add','script_introduction')) ">
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
				field: "script_collage_id",
				url_add: "~/api/script_collage/add?",
				url_set: "~/api/script_collage/set?",
				url_get_obj: "~/api/script_collage/get_obj?",
				url_upload: "~/api/script_collage/upload?",

				query: {
					"script_collage_id": 0,
				},

				form: {
								"script_name":  '', // 剧本名称
										"script_type":  '', // 剧本类型
										"script_price":  0, // 剧本价格
										"number_of_participants":  0, // 拼团人数
										"number_of_people_remaining":  0, // 剩余人数
										"instructions_for_teamwork":  '', // 拼团须知
										"cover_photo":  '', // 封面图片
										"script_introduction":  '', // 剧本简介
											"script_collage_id": 0, // ID
						
				},
				disabledObj:{
								"script_name_isDisabled": false,
										"script_type_isDisabled": false,
					          			"script_price_isDisabled": false,
					          			"number_of_participants_isDisabled": false,
					          			"number_of_people_remaining_isDisabled": false,
										"instructions_for_teamwork_isDisabled": false,
										"cover_photo_isDisabled": false,
										"script_introduction_isDisabled": false,
										},

	
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
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
					bl = this.$check_action('/script_collage/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/script_collage/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/script_collage/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/script_collage/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/script_collage/view','get');
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
