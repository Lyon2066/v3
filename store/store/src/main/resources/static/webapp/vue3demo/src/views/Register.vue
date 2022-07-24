<template name="component-name">
  <div class="login">
    <van-cell-group inset>
      <van-field v-model="userName" placeholder="输入姓名" label="用户名"/>
      <van-field v-model="phone" placeholder="输入手机号" type="tel" label="手机号"/>
      <van-field v-model="password" placeholder="输入密码" type="password" label="密码"/>
      <van-button @click="signIn" type="success" loading-type="spinner" size="large">注册</van-button>
    </van-cell-group>
  </div>
</template>
<script lang="ts">
import {defineComponent, ref} from "vue"
import {Toast, ToastOptions} from "vant"
import {usersReg} from '../util/LyonApi'

export default defineComponent({
  setup() {
    const userName = ref("")
    const phone = ref("")
    const password = ref("")
    return {userName, phone, password}
  },
  name: "Login",
  data() {
    return {}
  },
  methods: {
    signIn() {
      console.log("点击注册")
      console.log(this.userName)
      let params = {
        username: this.userName,
        password: this.password,
        phone: this.phone
      }
      usersReg(params).then((res: any) => {
        console.log(res)
        if(res.state === 200){
          Toast(res.message)
          setTimeout(()=>{
            this.$router.replace({name: 'login',path: '/login'})
          })
        }
      })
    }
  },
})
</script>
<style>
.login {
  width: 100vw;
  height: 100vh;
}
</style>
