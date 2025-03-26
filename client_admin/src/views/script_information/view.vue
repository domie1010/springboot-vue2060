<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','script_name') || $check_field('add','script_name') || $check_field('set','script_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本名称" prop="script_name">
												<el-input id="script_name" v-model="form['script_name']" placeholder="请输入剧本名称"
							  v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_name')) || (!form['script_information_id'] && $check_field('add','script_name'))" :disabled="disabledObj['script_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_name')">{{form['script_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_type') || $check_field('add','script_type') || $check_field('set','script_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本类型" prop="script_type">
												<el-input id="script_type" v-model="form['script_type']" placeholder="请输入剧本类型"
							  v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_type')) || (!form['script_information_id'] && $check_field('add','script_type'))" :disabled="disabledObj['script_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_type')">{{form['script_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_price') || $check_field('add','script_price') || $check_field('set','script_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本价格" prop="script_price">
								<el-input-number id="script_price" v-model.number="form['script_price']"
						v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_price')) || (!form['script_information_id'] && $check_field('add','script_price'))" :disabled="disabledObj['script_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','script_price')">{{form['script_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_rating') || $check_field('add','script_rating') || $check_field('set','script_rating')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本评分" prop="script_rating">
												<el-input id="script_rating" v-model="form['script_rating']" placeholder="请输入剧本评分"
							  v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_rating')) || (!form['script_information_id'] && $check_field('add','script_rating'))" :disabled="disabledObj['script_rating_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_rating')">{{form['script_rating']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_ranking') || $check_field('add','script_ranking') || $check_field('set','script_ranking')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本排行" prop="script_ranking">
								<el-input-number id="script_ranking" v-model.number="form['script_ranking']"
						v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_ranking')) || (!form['script_information_id'] && $check_field('add','script_ranking'))" :disabled="disabledObj['script_ranking_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','script_ranking')">{{form['script_ranking']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_description') || $check_field('add','script_description') || $check_field('set','script_description')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本描述" prop="script_description">
								<el-input type="textarea" id="script_description" v-model="form['script_description']" placeholder="请输入剧本描述"
						v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_description')) || (!form['script_information_id'] && $check_field('add','script_description'))" :disabled="disabledObj['script_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','script_description')">{{form['script_description']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_cover') || $check_field('add','script_cover') || $check_field('set','script_cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="剧本封面" prop="script_cover">
								<el-upload :disabled="disabledObj['script_cover_isDisabled']" id="script_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_script_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_cover')) || (!form['script_information_id'] && $check_field('add','script_cover'))">
						<img v-if="form['script_cover']" :src="$fullUrl(form['script_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','script_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['script_cover'])" :preview-src-list="[$fullUrl(form['script_cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','script_introduction') || $check_field('add','script_introduction') || $check_field('set','script_introduction')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="剧本简介" prop="script_introduction">
					<quill-editor v-model.number="form['script_introduction']"
						v-if="user_group === '管理员' || (form['script_information_id'] && $check_field('set','script_introduction')) || (!form['script_information_id'] && $check_field('add','script_introduction')) ">
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
				field: "script_information_id",
				url_add: "~/api/script_information/add?",
				url_set: "~/api/script_information/set?",
				url_get_obj: "~/api/script_information/get_obj?",
				url_upload: "~/api/script_information/upload?",

				query: {
					"script_information_id": 0,
				},

				form: {
								"script_name":  '', // 剧本名称
										"script_type":  '', // 剧本类型
										"script_price":  0, // 剧本价格
										"script_rating":  '', // 剧本评分
										"script_ranking":  0, // 剧本排行
										"script_description":  '', // 剧本描述
										"script_cover":  '', // 剧本封面
										"script_introduction":  '', // 剧本简介
											"script_information_id": 0, // ID
						
				},
				disabledObj:{
								"script_name_isDisabled": false,
										"script_type_isDisabled": false,
					          			"script_price_isDisabled": false,
										"script_rating_isDisabled": false,
					          			"script_ranking_isDisabled": false,
										"script_description_isDisabled": false,
										"script_cover_isDisabled": false,
										"script_introduction_isDisabled": false,
										},

	
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
						/**
			 * 上传剧本封面
			 * @param {Object} param 图片参数
			 */
			upload_script_cover(param){
						this.uploadFile(param.file, "script_cover");
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
					bl = this.$check_action('/script_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/script_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/script_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/script_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/script_information/view','get');
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
