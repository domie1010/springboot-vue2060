<template>
	<div class="diy_details page_script_collage" id="script_collage_details">
		<div class='warp'>
			<div class='container'>
				<div class='row'>
					<div class='col'>
						<div class='card_script_collage'>
							<div_script_collage :obj="obj"></div_script_collage>



						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</template>

<script>
	import div_script_collage from "@/components/diy/div_script_collage.vue";
	import mixin from "@/mixins/page.js";
	export default {
		mixins:[mixin],
		components:{
			div_script_collage
		},
		data(){
			return{
				url_get_obj: "~/api/script_collage/get_obj?",

				field: "script_collage_id",

				obj: {
				},

				query: {
						"script_name": "",
							"script_type": "",
							"script_price": 0,
							"number_of_participants": 0,
							"number_of_people_remaining": 0,
							"instructions_for_teamwork": "",
							"cover_photo": "",
							"script_introduction": "",
						"script_collage_id":0,
				},
				// 点赞
				praise: 0,
				// 点赞状态
				state_praise: false,
			}
		},
		methods:{
			get_obj_after(json) {
				// 判断是否获取到数据
				if (json && json.result && json.result.obj) {
					console.log(json.result.obj)
					var obj = json.result.obj;
					this.obj = obj
				}
			},

		},

		mounted() {
		},

	}
</script>

<style>
.qecode {
  display: flex;
  align-content: center;
  width: 270px;
  background: white;
  position: absolute;
  left: 20%;
  top: 20px;
  z-index: 999;
}
.qecodeImg {
  display: flex;
  flex-direction: column;
  align-content: center;
  text-align: center;
  padding-top: 10px;
  margin: 0 auto;
}
.btn_share{
	display: inline-block;
	position: relative;
	top: 15px;
	background: rgb(240, 238, 238);
	border: 1px solid #ccc;
	height: 38px;
	margin-left: 10px;
	padding: 3px 10px;
	cursor: pointer;
	overflow: hidden;
	border-radius: 5px;
}
.btn_share_icon{
	width: 30px;
	height: 28px;
	float: left;
	margin-right: 10px;
}
.share_box{
	display: none;
	float: left;
}
.share_box img{
	width: 30px;
	height: 28px;
	margin-right: 10px;
}
.btn_share:hover .share_box{
	display: block;
}
</style>
