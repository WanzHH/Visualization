<template>
  <body id="poster">
    <el-form class= "login-container" label-position="left" label-width="0px">
      <h3 class="login_title">
        登录
        <el-button @click="toRegister">注册账号</el-button>
      </h3>
      <el-form-item label="">
        <el-input type="text" v-model="loginForm.name" autocomplete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input type="password" v-model="loginForm.password" autocomplete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style= "width: 100%;background: #585458;border: none" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        name: '',
        password: '',
      }
    }
  },
  methods: {
    login() {
      console.log('submit!',this.loginForm);

      this.axios.post('http://localhost:3231/user_table/login',this.loginForm).then((resp)=>{
        let data = resp.data;
        console.log(resp);
        if(data.success){
          this.loginForm= {};
          this.$message({
            message: '欢迎光临后台管理系统!!!',
            type: 'success'
          });
          this.$router.push({path:'/Home'})
        }
        else
        {
          this.loginForm= {};
          this.$message.error('账号或密码输入错误');
        }
      })

    },
    toRegister(){
      this.$router.push({path:'/Register'})
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
    }
    body{
      margin: 0;
      padding: 0;
    }
    .login-container{
      border-radius:15px;
      background-clip: padding-box;
      margin:90px auto;
      width:350px;
      padding: 35px 35px 15px 35px;
      background: #fff;
      border:1px solid #eaeaea;
      box-shadow:0 0 25px #cac6c6;
    }
    .login_title{
      margin: 0 auto 40px auto;
      text-align:center;
      color: #505458;
    }

</style>
