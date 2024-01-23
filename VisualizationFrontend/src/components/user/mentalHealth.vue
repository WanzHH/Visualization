<template>
  <div class='main-container'>
    <el-container class="CSContainer">
      <el-main>
        <div class="form-container">
          <el-form>
            <el-form-item>
              <el-select v-model="searchForm.country" placeholder="请选择国家">
                <el-option label="Afghanistan" value="Afghanistan"></el-option>
                <el-option label="China" value="China"></el-option>
                <el-option label="Spain" value="Spain"></el-option>
                <el-option label="Slovenia" value="Slovenia"></el-option>
                <el-option label="Sweden" value="Slovenia"></el-option>
                <el-option label="Syria" value="Syria"></el-option>
                <el-option label="Turkey" value="Turkey"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
          <el-form>
            <el-form-item>
              <el-select v-model="searchForm.label" placeholder="请选择查询项目">
                <el-option label="Life Ladder" value="Life_Ladder"></el-option>
                <el-option label="Log GDP per capita" value="Log_GDP_per_capita"></el-option>
                <el-option label="Social support" value="Social_support"></el-option>
                <el-option label="Healthy life expectancy at birth" value="Healthy_life_expectancy_at_birth"></el-option>
                <el-option label="Freedom to make life choices" value="Freedom_to_make_life_choices"></el-option>
                <el-option label="Generosity" value="Generosity"></el-option>
                <el-option label="Perceptions of corruption" value="Perceptions_of_corruption"></el-option>
                <el-option label="Positive affect" value="Positive_affect"></el-option>
                <el-option label="Negative affect" value="Negative_affect"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
          <el-form>
            <el-form-item size="large" class="buttons">
              <el-button type="primary" @click="search">查询</el-button>
            </el-form-item>
          </el-form>
        </div>
        <div id="main" style="width: 858px;height:572px;"></div>
      </el-main>
    </el-container>

  </div>
</template>


<script>
import * as echarts from 'echarts';

export default {
  name: 'mentalHealth',
  data() {
    return {
      searchForm: {
        country:'',
        label:''
      },
      chartData: {
        years: [],
        selectedData: []
      }
    };
  },
  methods:{
    search() {
      // Implement your search logic here
      console.log('Searching for courses:', this.searchForm);
      // You may want to make an API request here to fetch the data based on the form values
      if(this.searchForm.country === ''){
        this.searchForm = {};
        this.$message.error('请选择国家');
      }
      if(this.searchForm.label === ''){
        this.searchForm = {};
        this.$message.error('请选择查询项目');
      }
      else{
        this.axios.post('http://localhost:3231/info/happiness', this.searchForm).then((resp) => {
          let data = resp.data.content;
          console.log(data);
          if (resp.data.success) {

            this.chartData.years = data.map(entry => entry.year);
            console.log(data.map(entry =>parseFloat(entry[this.searchForm.label])));
            console.log(data);
            this.chartData.selectedData = data.map(entry => parseFloat(entry[this.searchForm.label]));

            this.updateChart();

            }
          else {
            this.searchForm = {};
            this.$message.error('查询失败');
          }
        })
      }

    },
    updateChart() {
      var chartDom = document.getElementById('main');
      var myChart = echarts.init(chartDom);
      myChart.clear();  // 清空图表容器
      var option;

      // 使用图表数据更新 ECharts 的配置
      option = {
        title: {
          text: 'country:' + this.searchForm.country
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: [this.searchForm.label]
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.chartData.years
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: this.searchForm.label,
            type: 'line',
            stack: 'Total',
            data: this.chartData.selectedData
          }
        ]
      };

      option && myChart.setOption(option);
    }
  }
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

.CSContainer{
  border-radius:15px;
  background-clip: padding-box;
  margin:0 240px 100px 240px;
  width:350px;
  padding: 15px 15px 15px 15px;
  background: #eeaef2;
  border:5px solid #6F2ADD;
}

.form-container {
  display: flex;
}

/* 可以根据需要添加其他样式 */
.el-form-item {
  margin-right: 20px; /* 调整 el-form-item 之间的间距 */
}
</style>
