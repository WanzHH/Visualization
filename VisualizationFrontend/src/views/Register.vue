<template>
  <div id="poster">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="0px" label-position="left" class="register-container">
      <h3 class="register_title">
        账号注册
        <el-button @click="toLogin">去登陆</el-button>
      </h3>
      <el-form-item label="" prop="name">
        <el-input type="text" v-model="ruleForm.name" autocomplete="off" placeholder="请输入用户名" prefix-icon="el-icon-user-solid"></el-input>
      </el-form-item>
      <el-form-item label=""  prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码" prefix-icon="el-icon-lock"></el-input>
      </el-form-item>
      <el-form-item label="" prop="checkPass" placeholder="账号">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" placeholder="请输入确认密码" prefix-icon="el-icon-lock"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style= "background: #585458;border: none" @click="submitForm(ruleForm)">注册</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data() {
    var validateName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        name: '',
        password: '',
        checkPass: ''
      },
      rules: {
        name: [
          { validator: validateName, trigger: 'blur' }
        ],
        password: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(ruleForm) {
      this.axios.post('http://localhost:3231/user_table/register',this.ruleForm).then((resp)=> {
            console.log(resp);
            let data = resp.data;
            console.log(data);
            if (data.success) {
              this.ruleForm = {};
              this.$message({
                message: '恭喜你,注册成功,点击去登陆按钮进行登陆吧!!!',
                type: 'success'
              });
            }
          })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    toLogin(){
      this.$router.push({path:'/'})
    }
  }
}
</script>

<style>
#poster{
  background-position: center;
  height:100%;
  width:100%;
  background-size: cover;
  position: fixed;
  margin: 0;
  padding: 0;
}
.register-container{
  border-radius:15px;
  background-clip: padding-box;
  margin:90px auto;
  width:350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border:1px solid #eaeaea;
  box-shadow:0 0 25px #cac6c6;
}
.register_title{
  margin: 0 auto 40px auto;
  text-align:center;
  color: #505458;
}

</style>
