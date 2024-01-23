<template>
  <div class="home">
    <myHeader></myHeader>
    <my-main></my-main>
    <myFooter></myFooter>
    <myMenu></myMenu>
  </div>
</template>

<script>
import myHeader from "@/components/header.vue";
import myFooter from "@/components/footer.vue";
import myMenu from "@/components/user/menuUser.vue";
import myMain from "@/components/user/mentalHealth.vue";
export default {
  components: {
    myHeader,
    myFooter,
    myMenu,
    myMain
  },
  name: 'HomeViewStu',
}
</script>

<style scoped>
.home {
  margin: 0;
  padding: 0;
}
</style>
