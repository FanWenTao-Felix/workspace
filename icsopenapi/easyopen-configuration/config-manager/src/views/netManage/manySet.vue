<template>
  <el-dialog title="限流设置" :visible="manyVisiable" @close="cancel">
    <el-form :model="form" status-icon :rules="rules" ref="form" label-position="left" label-width="130px" style='padding:0 50px'>
       <el-form-item label="策略">
        <el-radio-group v-model="form.limitType">
          <el-radio label="LIMIT">限流策略</el-radio>
          <el-radio label="TOKEN_BUCKET">令牌桶策略</el-radio>
        </el-radio-group>
      </el-form-item>
       <el-form-item label="状态">
        <el-radio-group v-model="form.status">
          <el-radio label="1">开启</el-radio>
          <el-radio label="0">禁用</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-card class="box-card" v-if="form.status==1">
          <div v-if="form.limitType=='TOKEN_BUCKET'" slot="header" class="clearfix">
            <span>令牌桶策略(每秒放置固定数量的令牌数，不足的令牌数做等待处理，直到拿到令牌为止。)</span>
          </div>
          <div  class="component-item">
          <div className="mallki-text" v-if="form.limitType=='TOKEN_BUCKET'">
            <el-form-item label="令牌桶流量">
                <el-input type="text" v-model="form.tokenBucketCount"></el-input>
            </el-form-item>
            </div>
          </div>
          <div v-if="form.limitType=='LIMIT'" slot="header" class="clearfix">
            <span>限流策略(每秒处理固定数量的请求，超出请求返回错误信息。)</span>
          </div>
          <div  class="component-item">
          <div className="mallki-text" v-if="form.limitType=='LIMIT'">
            <el-form-item label="每秒处理请求数">
                <el-input type="text" v-model="form.limitCount"></el-input>
            </el-form-item>
            <el-form-item label="限制后返回code" prop="limitCode">
                <el-input type="text" v-model="form.limitCode"></el-input>
            </el-form-item>
            <el-form-item label="限制后返回msg" prop="limitMsg">
                <el-input type="text" v-model="form.limitMsg"></el-input>
            </el-form-item>
            </div>
          </div>
      </el-card>
    </el-form>
    <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取消</el-button>
        <el-button type="primary" @click="saveConfig">设置</el-button>
    </div>
  </el-dialog>
</template>
<script>
  import ApiUtil from '@/utils/ApiUtil'
  export default {
    props:{
      manyVisiable:{
        type:Boolean,
        default:false
      },
    },
    data(){
      return {
        form: {
          limitCode:'',
          status:'1',
          limitType:"LIMIT",
          limitMsg:'',
          apiIds:[],
          limitCount:50,
          tokenBucketCount:50,
          app:''
        },
        reLoad:false,
        multipleSelection:[],
        rules: {
          limitMsg: [
            { required: true, message: '该项为必输项', trigger: 'blur' }
          ],
          limitCode: [
            { required: true, message: '该项为必输项', trigger: 'blur' }
          ],
          
        },
      }
    },
    methods:{
      checked(multipleSelection,app){
        this.multipleSelection = multipleSelection
        this.form.app = app
      },
      saveConfig() {
        var that = this
        that.form.apiIds = []
        that.multipleSelection.forEach( val =>{
            that.form.apiIds.push(val.apiId)
        })
        
        this.$refs.form.validate((valid) => {
          if (valid) {
            ApiUtil.post("app.limit.update",that.form,function(resp){
              if(resp.code=='0'){
                that.$message({
                  message: '设置成功',
                  type: 'success'
                });
                that.cancel(true)
              }
            })
          } else {
            console.log('请填写完整');
            return false;
          }
        });
      },
      cancel(data){
        if(data==true){
          this.reLoad = data
        }else{
          this.reLoad = false
        }
        this.$refs.form.clearValidate();
        this.$emit('closeDialog',false,this.reLoad)
      },
    }
  }
</script>
<style>

</style>
