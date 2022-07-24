<template name="component-name">
  <div class="login">
    <h1>请登录</h1>
    <van-cell-group inset>
      <van-field v-model="userName" placeholder="输入姓名" label="用户名"/>
      <van-field
          v-model="phone"
          placeholder="输入手机号"
          type="tel"
          label="手机号"
      />
      <van-field
          v-model="password"
          placeholder="输入密码"
          type="password"
          label="密码"
      />
      <van-button
          @click="signUp"
          type="success"
          loading-type="spinner"
          size="large"
      >登录
      </van-button
      >
    </van-cell-group>
  </div>
</template>
<script lang="ts">
import {defineComponent, ref} from "vue"
import {usersLogin} from '../util/LyonApi'

export default defineComponent({
  setup() {
    const userName = ref("")
    const phone = ref("")
    const password = ref("")
    return {userName, phone, password}
  },
  name: "Login",
  data() {
    return {
      title: '登录'
    }
  },
  methods: {
    signUp() {
      console.log(this.title)
      console.log(this.userName)
      // this.$router.push({ path: "/Home" })
      let params = {
        username: this.userName,
        password: this.password
      }
      usersLogin(params).then((res: unknown) => {
        console.log(res)
      })
    },
  },
})
</script>
<style>
.login {
  width: 100vw;
  height: 100vh;
}
</style>
