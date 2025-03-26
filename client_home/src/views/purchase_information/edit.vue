<template>
	<div class="diy_edit page_purchase_information" id="purchase_information_edit">
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
							<div v-if="$check_field('set','script_price') || $check_field('add','script_price') || $check_field('get','script_price')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								剧本价格:
							</span>
						</div>
								<!-- 数字 -->
						<div class="diy_field diy_number">
							<input type="number" id="form_script_price" v-model.number="form['script_price']" placeholder="请输入剧本价格" v-if="(form['script_price'] && $check_field('set','script_price')) || (!form['script_price'] && $check_field('add','script_price'))" :disabled="disabledObj['script_price_isDisabled']" />
							<span v-else-if="$check_field('get','script_price')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','purchase_user') || $check_field('add','purchase_user') || $check_field('get','purchase_user')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								购买用户:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_purchase_user" :disabled="disabledObj['purchase_user_isDisabled']" v-model="form['purchase_user']" v-if="(form['purchase_user'] && $check_field('set','purchase_user')) || (!form['purchase_user'] && $check_field('add','purchase_user'))" >
								<option v-for="o in list_user_purchase_user" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','purchase_user')">{{ form['purchase_user'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_user_name" v-model="form['user_name']" placeholder="请输入用户姓名" v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))"  :disabled="disabledObj['user_name_isDisabled']"/>
							<span v-else-if="$check_field('get','user_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','user_phone') || $check_field('add','user_phone') || $check_field('get','user_phone')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户电话:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_user_phone" v-model="form['user_phone']" placeholder="请输入用户电话" v-if="(form['user_phone'] && $check_field('set','user_phone')) || (!form['user_phone'] && $check_field('add','user_phone'))"  :disabled="disabledObj['user_phone_isDisabled']"/>
							<span v-else-if="$check_field('get','user_phone')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','purchase_time') || $check_field('add','purchase_time') || $check_field('get','purchase_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								购买时间:
							</span>
						</div>
								<!-- 日长 -->
						<div class="diy_field diy_datetime">
							<input type="datetime-local" :disabled="disabledObj['purchase_time_isDisabled']" id="form_purchase_time" v-model="form['purchase_time']" placeholder="请输入购买时间" v-if="(form['purchase_time'] && $check_field('set','purchase_time')) || (!form['purchase_time'] && $check_field('add','purchase_time'))" />
							<span v-else-if="$check_field('get','purchase_time')">{{ form['${obj.name}'] }}</span>
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
				url_get_obj: "~/api/purchase_information/get_obj?",
				url_add: "~/api/purchase_information/add?",
				url_set: "~/api/purchase_information/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"script_name": "",
							"script_type": "",
							"script_price": 0,
							"purchase_user": 0,
							"user_name": "",
							"user_phone": "",
							"purchase_time": "",
						"purchase_information_id": 0,
				},

				obj: {
						"script_name":  '', // 剧本名称
							"script_type":  '', // 剧本类型
							"script_price":  0, // 剧本价格
							"purchase_user": 0, // 购买用户
							"user_name":  '', // 用户姓名
							"user_phone":  '', // 用户电话
							"purchase_time": new Date().getTime(),
						"purchase_information_id": 0,
				},

				// 表单字段
				form: {
						"script_name":  '', // 剧本名称
							"script_type":  '', // 剧本类型
							"script_price":  0, // 剧本价格
							"purchase_user": 0, // 购买用户
							"user_name":  '', // 用户姓名
							"user_phone":  '', // 用户电话
							"purchase_time": new Date().getTime(),
						"purchase_information_id": 0,
				},
				disabledObj:{
						"script_name_isDisabled": false,
							"script_type_isDisabled": false,
									"purchase_user_isDisabled": false,
							"user_name_isDisabled": false,
							"user_phone_isDisabled": false,
							"purchase_time_isDisabled": false,
					},

												// 用户列表
				list_user_purchase_user: [],
							
				// ID字段
				field: "purchase_information_id",

			}
		},
		methods: {
			
				
				
						/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_purchase_user() {
				// if(this.user_group !== "管理员" && this.form["purchase_user"] === 0) {
				//     this.form["purchase_user"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=普通用户");
				if(json.result && json.result.list){
					this.list_user_purchase_user = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
					async get_user_session_purchase_user(){
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
								_this.form["purchase_user"] = user_id
								_this.disabledObj['purchase_user' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "purchase_user") {
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
				this.$post("~/api/purchase_information/upload?", form, (res) => {
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
													        if (JSON.stringify(this.form["purchase_time"]).indexOf("-")===-1) {
          this.form["purchase_time"] = this.$toTime(parseInt(this.form["purchase_time"]), "yyyy-MM-ddThh:mm")
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
														this.get_user_session_purchase_user();
					this.get_list_user_purchase_user();
												},
	}
</script>

<style>




</style>
