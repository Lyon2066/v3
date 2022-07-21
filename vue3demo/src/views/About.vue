<script setup lang="ts">
import HelloWorld from "../components/HelloWorld.vue"
import { ref, defineComponent, defineProps } from "vue"
defineProps<{ msg: string }>()

const count = ref(0)
const addCount = () => {
  console.log(count.value)
}
defineComponents:{
  HelloWorld
}
// export default defineComponent({
//   setup() {},
//   components: {
//     HelloWorld,
//   },
//   methods: {
//     addCount() {
//       console.log(this)
//     },
//   },
// })
</script>

<template>
  <h1>About</h1>
  <h2>{{ count }}</h2>
  <button @click="addCount">Click Me</button>
  <hello-world></hello-world>
</template>

<style scoped></style>
