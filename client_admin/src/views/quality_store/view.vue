<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','store_name') || $check_field('add','store_name') || $check_field('set','store_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺名称" prop="store_name">
												<el-input id="store_name" v-model="form['store_name']" placeholder="请输入店铺名称"
							  v-if="user_group === '管理员' || (form['quality_store_id'] && $check_field('set','store_name')) || (!form['quality_store_id'] && $check_field('add','store_name'))" :disabled="disabledObj['store_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_name')">{{form['store_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','store_address') || $check_field('add','store_address') || $check_field('set','store_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺地址" prop="store_address">
												<el-input id="store_address" v-model="form['store_address']" placeholder="请输入店铺地址"
							  v-if="user_group === '管理员' || (form['quality_store_id'] && $check_field('set','store_address')) || (!form['quality_store_id'] && $check_field('add','store_address'))" :disabled="disabledObj['store_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_address')">{{form['store_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','per_capita_price') || $check_field('add','per_capita_price') || $check_field('set','per_capita_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="人均价格" prop="per_capita_price">
								<el-input-number id="per_capita_price" v-model.number="form['per_capita_price']"
						v-if="user_group === '管理员' || (form['quality_store_id'] && $check_field('set','per_capita_price')) || (!form['quality_store_id'] && $check_field('add','per_capita_price'))" :disabled="disabledObj['per_capita_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','per_capita_price')">{{form['per_capita_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','store_description') || $check_field('add','store_description') || $check_field('set','store_description')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺描述" prop="store_description">
								<el-input type="textarea" id="store_description" v-model="form['store_description']" placeholder="请输入店铺描述"
						v-if="user_group === '管理员' || (form['quality_store_id'] && $check_field('set','store_description')) || (!form['quality_store_id'] && $check_field('add','store_description'))" :disabled="disabledObj['store_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_description')">{{form['store_description']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shop_cover') || $check_field('add','shop_cover') || $check_field('set','shop_cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺封面" prop="shop_cover">
								<el-upload :disabled="disabledObj['shop_cover_isDisabled']" id="shop_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_shop_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['quality_store_id'] && $check_field('set','shop_cover')) || (!form['quality_store_id'] && $check_field('add','shop_cover'))">
						<img v-if="form['shop_cover']" :src="$fullUrl(form['shop_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','shop_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['shop_cover'])" :preview-src-list="[$fullUrl(form['shop_cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shop_introduction') || $check_field('add','shop_introduction') || $check_field('set','shop_introduction')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="店铺简介" prop="shop_introduction">
					<quill-editor v-model.number="form['shop_introduction']"
						v-if="user_group === '管理员' || (form['quality_store_id'] && $check_field('set','shop_introduction')) || (!form['quality_store_id'] && $check_field('add','shop_introduction')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','shop_introduction')" v-html="form['shop_introduction']"></div>
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
				field: "quality_store_id",
				url_add: "~/api/quality_store/add?",
				url_set: "~/api/quality_store/set?",
				url_get_obj: "~/api/quality_store/get_obj?",
				url_upload: "~/api/quality_store/upload?",

				query: {
					"quality_store_id": 0,
				},

				form: {
								"store_name":  '', // 店铺名称
										"store_address":  '', // 店铺地址
										"per_capita_price":  0, // 人均价格
										"store_description":  '', // 店铺描述
										"shop_cover":  '', // 店铺封面
										"shop_introduction":  '', // 店铺简介
											"quality_store_id": 0, // ID
						
				},
				disabledObj:{
								"store_name_isDisabled": false,
										"store_address_isDisabled": false,
					          			"per_capita_price_isDisabled": false,
										"store_description_isDisabled": false,
										"shop_cover_isDisabled": false,
										"shop_introduction_isDisabled": false,
										},

	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
						/**
			 * 上传店铺封面
			 * @param {Object} param 图片参数
			 */
			upload_shop_cover(param){
						this.uploadFile(param.file, "shop_cover");
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
					bl = this.$check_action('/quality_store/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/quality_store/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/quality_store/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/quality_store/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/quality_store/view','get');
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
