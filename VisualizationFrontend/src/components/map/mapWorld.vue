<template>
  <div class="main-container">
    <el-container>
      <el-main>
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div id="main" style="width: 1458px; height: 972px; padding: 50px;"></div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import '@/js/echarts.min.js';
import '@/js/world';

export default {
  name: 'WorldMap',
  data() {
    return {
      name_title: '因非传染性疾病过早死亡的概率',
      mapName: 'world',
      data: [
        { name: 'Albania', value: 11.39601 },
        { name: 'Algeria', value: 13.85875 },
        { name: 'Afghanistan', value: 35.27428 },
        { name: 'Argentina', value: 15.72067 },
        { name: 'United Arab Emirates', value: 18.50345 },
        { name: 'Arab Republic of Syria', value: 22.11282 },
        { name: 'Oman', value: 21.47854 },
        { name: 'Azerbaijan', value: 27.20014 },
        { name: 'Egypt', value: 28.03471 },
        { name: 'Ethiopia', value: 17.09935 },
        { name: 'Ireland', value: 9.65748 },
        { name: 'Estonia', value: 14.90192 },
        { name: 'Angola', value: 22.24695 },
        { name: 'Antigua and Barbuda', value: 17.54642 },
        { name: 'Austria', value: 10.36782 },
        { name: 'Australia', value: 8.58537 },
        { name: 'Barbados', value: 15.95721 },
        { name: 'Papua New Guinea', value: 35.95613 },
        { name: 'Bahamas', value: 19.89816 },
        { name: 'Pakistan', value: 29.41299 },
        { name: 'Paraguay', value: 16.02444 },
        { name: 'Bahrain', value: 16.05922 },
        { name: 'Panama', value: 10.6979 },
        { name: 'Brazil', value: 15.49638 },
        { name: 'Belarus', value: 23.75091 },
        { name: 'Bulgaria', value: 24.15713 },
        { name: 'North Macedonia', value: 22.73179 },
        { name: 'Benin', value: 22.62415 },
        { name: 'Belgium', value: 10.56445 },
        { name: 'Iceland', value: 8.65321 },
        { name: 'Poland', value: 16.97474 },
        { name: 'Bosnia and Herzegovina', value: 18.71701 },
        { name: 'Bolivia', value: 17.88433 },
        { name: 'Belize', value: 16.46762 },
        { name: 'Botswana', value: 27.0326 },
        { name: 'Bhutan', value: 18.45957 },
        { name: 'Burkina Faso', value: 23.93053 },
        { name: 'Burundi', value: 24.96597 },
        { name: 'Dem. Rep. Korea', value: 23.93753 },
        { name: 'Equatorial Guinea', value: 22.13812 },
        { name: 'United Kingdom', value: 10.29892 },
        { name: 'Korea', value: 7.26556 },
        { name: 'Denmark', value: 10.77049 },
        { name: 'Germany', value: 12.05419 },
        { name: 'Timor-Leste', value: 19.94579 },
        { name: 'Togo', value: 23.85005 },
        { name: 'Dominican Republic', value: 19.13208 },
        { name: 'Russia', value: 24.20199 },
        { name: 'Ecuador', value: 11.03699 },
        { name: 'Eritrea', value: 26.80168 },
        { name: 'France', value: 10.58292 },
        { name: 'Philippines', value: 24.52524 },
        { name: 'Fiji', value: 37.6787 },
        { name: 'Finland', value: 9.60175 },
        { name: 'Cape Verde', value: 17.44297 },
        { name: 'Gambia', value: 21.08724 },
        { name: 'Congo', value: 22.59979 },
        { name: 'Democratic Republic of the Congo', value: 24.04843 },
        { name: 'Colombia', value: 9.73468 },
        { name: 'Costa Rica', value: 9.53475 },
        { name: 'Grenada', value: 23.34891 },
        { name: 'Georgia', value: 24.89242 },
        { name: 'Cuba', value: 16.58107 },
        { name: 'Guyana', value: 29.18983 },
        { name: 'Kazakhstan', value: 22.41804 },
        { name: 'Haiti', value: 31.33782 },
        { name: 'Kingdom of the Netherlands', value: 10.34735 },
        { name: 'Montenegro', value: 22.3043 },
        { name: 'Honduras', value: 18.67587 },
        { name: 'Kiribati', value: 50.84999 },
        { name: 'Djibouti', value: 22.01451 },
        { name: 'Kyrgyzstan', value: 20.33676 },
        { name: 'Guinea', value: 24.90209 },
        { name: 'Guinea-Bissau', value: 24.85319 },
        { name: 'Canada', value: 9.61899 },
        { name: 'Ghana', value: 22.46803 },
        { name: 'Gabon', value: 21.33054 },
        { name: 'Cambodia', value: 22.5075 },
        { name: 'Czech Republic', value: 14.25335 },
        { name: 'Zimbabwe', value: 28.3875 },
        { name: 'Cameroon', value: 23.91907 },
        { name: 'Qatar', value: 10.74122 },
        { name: 'Comoros', value: 20.62296 },
        { name: 'Côte dIvoire', value: 21.71013 },
        { name: 'Kuwait', value: 11.89492 },
        { name: 'Croatia', value: 16.07339 },
        { name: 'Kenya', value: 20.99061 },
        { name: 'Latvia', value: 21.6358 },
        { name: 'Lesotho', value: 42.73358 },
        { name: 'Lao PDR', value: 26.82164 },
        { name: 'Lebanon', value: 19.86696 },
        { name: 'Lithuania', value: 19.31542 },
        { name: 'Liberia', value: 17.75093 },
        { name: 'Libya', value: 18.59222 },
        { name: 'Luxembourg', value: 9.74565 },
        { name: 'Rwanda', value: 20.22767 },
        { name: 'Romania', value: 20.95173 },
        { name: 'Madagascar', value: 25.98656 },
        { name: 'Maldives', value: 11.57016 },
        { name: 'Malta', value: 10.52524 },
        { name: 'Malawi', value: 22.55138 },
        { name: 'Malaysia', value: 18.44623 },
        { name: 'Mali', value: 22.33635 },
        { name: 'Mauritius', value: 23.19164 },
        { name: 'Mauritania', value: 16.10187 },
        { name: 'United States', value: 13.55883 },
        { name: 'Mongolia', value: 35.0336 },
        { name: 'Bangladesh', value: 18.88798 },
        { name: 'Peru', value: 9.73561 },
        { name: 'Federated States of Micronesia', value: 46.28722 },
        { name: 'Myanmar', value: 24.9111 },
        { name: 'Republic of Moldova', value: 24.06048 },
        { name: 'Morocco', value: 24.13039 },
        { name: 'Mozambique', value: 30.55536 },
        { name: 'Mexico', value: 15.60117 },
        { name: 'Namibia', value: 22.62095 },
        { name: 'South Africa', value: 24.13278 },
        { name: 'South Sudan', value: 16.81432 },
        { name: 'Nepal', value: 21.50248 },
        { name: 'Nicaragua', value: 15.32533 },
        { name: 'Niger', value: 20.95823 },
        { name: 'Nigeria', value: 16.90245 },
        { name: 'Norway', value: 8.69011 },
        { name: 'Portugal', value: 10.99051 },
        { name: 'Japan', value: 8.26117 },
        { name: 'Sweden', value: 8.37683 },
        { name: 'Switzerland', value: 7.88999 },
        { name: 'El Salvador', value: 10.67081 },
        { name: 'Samoa', value: 31.1977 },
        { name: 'Serbia', value: 21.95099 },
        { name: 'Sierra Leone', value: 23.54696 },
        { name: 'Senegal', value: 19.52728 },
        { name: 'Cyprus', value: 8.19378 },
        { name: 'Seychelles', value: 21.10892 },
        { name: 'Saudi Arabia', value: 20.89609 },
        { name: 'Sao Tome and Principe', value: 20.97365 },
        { name: 'Saint Lucia', value: 17.68382 },
        { name: 'Saint Vincent and the Grenadines', value: 20.65362 },
        { name: 'Sri Lanka', value: 13.20548 },
        { name: 'Slovakia', value: 15.47442 },
        { name: 'Slovenia', value: 11.44503 },
        { name: 'Swaziland', value: 35.24147 },
        { name: 'Sudan', value: 22.80054 },
        { name: 'Suriname', value: 22.74178 },
        { name: 'Solomon Islands', value: 39.20307 },
        { name: 'Somalia', value: 30.4087 },
        { name: 'Tajikistan', value: 28.33378 },
        { name: 'Thailand', value: 13.73192 },
        { name: 'United Republic of Tanzania', value: 17.4054 },
        { name: 'Tonga', value: 24.79835 },
        { name: 'Trinidad and Tobago', value: 17.13826 },
        { name: 'Tunisia', value: 15.72825 },
        { name: 'Turkey', value: 15.62715 },
        { name: 'Turkmenistan', value: 27.70148 },
        { name: 'Vanuatu', value: 39.72181 },
        { name: 'Guatemala', value: 16.47276 },
        { name: 'Venezuela', value: 14.79505 },
        { name: 'Brunei Darussalam', value: 18.5248 },
        { name: 'Uganda', value: 21.17073 },
        { name: 'Ukraine', value: 25.52477 },
        { name: 'Uruguay', value: 16.4621 },
        { name: 'Uzbekistan', value: 25.2994 },
        { name: 'Spain', value: 9.60723 },
        { name: 'Greece', value: 12.47716 },
        { name: 'Singapore', value: 9.46947 },
        { name: 'New Zealand', value: 10.25782 },
        { name: 'Hungary', value: 22.12835 },
        { name: 'Jamaica', value: 16.87925 },
        { name: 'Armenia', value: 19.92932 },
        { name: 'Yemen', value: 27.5996 },
        { name: 'Iraq', value: 23.54735 },
        { name: 'Iran', value: 14.80349 },
        { name: 'Israel', value: 8.78254 },
        { name: 'Italy', value: 8.96685 },
        { name: 'India', value: 21.85158 },
        { name: 'Indonesia', value: 24.80398 },
        { name: 'Jordan', value: 15.30141 },
        { name: 'Vietnam', value: 21.24348 },
        { name: 'Zambia', value: 24.56461 },
        { name: 'Chad', value: 22.73849 },
        { name: 'Chile', value: 10.03513 },
        { name: 'Central African Republic', value: 36.00362 },
        { name: 'China', value: 15.85141 }



        // { name: 'China', value: 17252 },
        // { name: 'Japan', value: 20 },
        // { name: 'Thailand', value: 19 },
        // { name: 'Singapore', value: 18 },
        // { name: 'Korea', value: 15 },
        // { name: 'Australia', value: 12 },
        // { name: 'United States', value: 11 },
        // { name: 'Germany', value: 10 },
        // { name: 'Malaysia', value: 8 },
        // { name: 'Vietnam', value: 7 },
        // { name: 'France', value: 6 },
        // { name: 'United Arab Emirates', value: 5 },
        // { name: 'Canada', value: 4 },
        // { name: 'India', value: 3 },
        // { name: 'Philippines', value: 2 },
        // { name: 'Italy', value: 2 },
        // { name: 'United Kingdom', value: 2 },
        // { name: 'Russia', value: 2 },
        // { name: 'Nepal', value: 1 },
        // { name: 'Sri Lanka', value: 1 },
        // { name: 'Finland', value: 1 },
        // { name: 'Sweden', value: 1 },
        // { name: 'Cambodia', value: 1 },
      ],
    };
  },
  mounted() {
    this.$nextTick(() => {
      // 基于准备好的 DOM，初始化 ECharts 实例
      const myChart = echarts.init(document.getElementById('main'));

      // 指定图表的配置项和数据
      const option = {
        title: {
          text: this.name_title,
          x: 'center',
          textStyle: {
            fontSize: 24,
          },
        },
        tooltip: {
          trigger: 'item',
          formatter: (params) => {
            let toolTiphtml = '';
            if (isNaN(params.value)) {
              toolTiphtml = params.name + '0%';
            } else {
              toolTiphtml = params.name + '比率: ' + params.value + '%';
            }
            return toolTiphtml;
          },
        },
        toolbox: {
          feature: {
            saveAsImage: {},
          },
        },
        visualMap: {
          show: true,
          left: 'left',
          top: 'bottom',
          seriesIndex: [0],
          type: 'piecewise',
          pieces: [
            { min: 25.1, color: 'rgb(254,57,101)' },
            { min: 20.1, max: 25 , color: 'rgb(252,157,154)' },
            { min: 15.1, max: 20, color: 'rgb(249,205,173)' },
            { min: 10.1, max: 15, color: 'rgb(200,200,169)' },
            { min: 0.1, max: 10, color: 'rgb(131,175,155)' },
          ],
          textStyle: {
            color: '#000000',
          },
        },
        geo: {
          show: true,
          map: this.mapName,
          label: {
            normal: {
              show: false,
              fontSize: 12,
            },
            emphasis: {
              show: false,
            },
          },
          roam: true,
          itemStyle: {
            normal: {
              areaColor: '#F6F6F6',
              borderColor: '#666666',
            },
            emphasis: {
              areaColor: '#0099CC',
            },
          },
        },
        series: [
          {
            type: 'map',
            map: this.mapName,
            geoIndex: 0,
            animation: false,
            data: this.data,
          },
        ],
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    });
  },
};
</script>

<style scoped>
/* 根据需要添加样式 */
.map-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f0f0f0;
}
.main-container {
  display: flex;
//flex-direction: column;
  min-height: 100vh;
  background-color: #eeaef2;
  flex: 1; /* 使 .main-container 占据剩余的所有空间 */
}

</style>
