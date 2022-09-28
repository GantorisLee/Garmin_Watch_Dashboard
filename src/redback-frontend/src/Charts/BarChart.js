import React, {useEffect, useState} from 'react';
import FusionCharts from 'fusioncharts';
import Charts from 'fusioncharts/fusioncharts.charts';
import ReactFC from 'react-fusioncharts';
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';

// Resolves charts dependancy
ReactFC.fcRoot(FusionCharts, Charts, FusionTheme);

const BarChart = ({timeLineData}) => {
    const [timeLineDistance, setTimeLineDistance] = useState([]);

    const dataSource = {
        chart: {
            caption: "Moving Distance Per Day",
            captionFont:'Roboto',
            // subcaption: "In MMbbl = One Million barrels",
            xaxisname: "Date",
            yaxisname: "Meters (m)",
            numbersuffix: "m",
            theme: "fusion",
            palettecolors: "#66c0ff",
            usePlotGradientColor: "1",
            plotGradientColor: "#45a6dc",
            // showBorder: "1",
        },
        data: timeLineDistance
    };

    const chartConfigs = {
        type: 'column2d',
        width: '100%',
        height: '95%',
        dataFormat: 'json',
        dataSource: dataSource,
    };

    useEffect(() => {
        setTimeLineDistance(timeLineData.reverse().map(item => {
            return {label: item.date.split('/').slice(1,3).join('-'), value: Math.floor(item.distance)}

        }))
        // console.log(timeLineDistance)
    }, [timeLineData])

    return (
        <div style={{display:'block', margin:'auto', width:'95%'}}>
                <ReactFC {...chartConfigs} />
        </div>
    )
}

export default BarChart;

