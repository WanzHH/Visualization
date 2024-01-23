<template>
  <div class='header'>
    <el-header>
      <div class='title'>
        医疗数据分析
      </div>

    </el-header>
  </div>
</template>

<script>
export default {
  name: 'header',
};
</script>

<style scoped>
@font-face {
  font-family: 'pixelmplus12regular';
  src: url('../css/fonts/PixelMplus12-Regular.woff.ttf') format('woff');
  /* 添加其他格式的字体文件路径和声明，以确保在不同浏览器中的兼容性 */
  font-weight: normal;
  font-style: normal;
}

.header {
  background: linear-gradient(to bottom, #6F2ADD, #eeaef2);
  color: #fff;
  line-height: 60px;
  display: flex;
  justify-content: space-between;
}
.title {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  font-size: 24px;
}
.subtitle {
  font-size: 18px;
}
</style>
