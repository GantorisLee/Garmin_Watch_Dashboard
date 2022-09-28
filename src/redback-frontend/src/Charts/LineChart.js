import React, {useEffect, useState} from 'react';
import FusionCharts from 'fusioncharts';
import Charts from 'fusioncharts/fusioncharts.charts';
import ReactFC from 'react-fusioncharts';
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';

// Resolves charts dependancy
ReactFC.fcRoot(FusionCharts, Charts, FusionTheme);

const LineChart = ({timeLineData}) => {
    const [timeLineCalories, setTimeLineCalories] = useState([]);

    const dataSource = {
        chart: {
            caption: "Calories Consumed Per Day",
            captionFont:'Roboto',
            yaxisname: "Calories (in cal)",
            subcaption: "[2022]",
            numbersuffix: " cal",
            rotatelabels: "1",
            setadaptiveymin: "1",
            theme: "fusion"
        },
        data: timeLineCalories
    };

    const chartConfigs = {
        type: "line",
        width: "100%",
        height: "95%",
        dataFormat: "JSON",
        dataSource: dataSource
    };

    useEffect(() => {
        setTimeLineCalories(timeLineData.reverse().map(item => {
            return {label: item.date.split('/').slice(1,3).join('-'), value: item.calories}

        }))
        // console.log(timeLineCalories)
    }, [timeLineData])

    return (
        <div style={{display: 'block', margin: 'auto', width: '95%'}}>
            <ReactFC {...chartConfigs} />
        </div>
    )
}

export default LineChart;