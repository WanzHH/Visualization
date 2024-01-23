<template>
  <div class='main-container'>
      <el-container>
        <el-main>
        </el-main>
      </el-container>
  </div>
</template>


<script>
import * as echarts from 'echarts';

export default {
  name: 'main',
  data() {
    return {};
  },
};
</script>

<style>
/* 更改 .layout 为 .main-container */
.main-container {
  display: flex;
//flex-direction: column;
  min-height: 100vh;
  background-color: #eeaef2;
  flex: 1; /* 使 .main-container 占据剩余的所有空间 */
}
.aside {
  width: 240px; /* 设置侧边栏的宽度 */
  background-color: #eeaef2;
  color: #eeaef2;
}
</style>
