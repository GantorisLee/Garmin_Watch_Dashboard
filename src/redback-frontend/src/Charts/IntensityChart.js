import React, {useEffect, useState} from 'react';
import FusionCharts from 'fusioncharts';
import Charts from 'fusioncharts/fusioncharts.charts';
import ReactFC from 'react-fusioncharts';
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';
// Resolves charts dependancy
ReactFC.fcRoot(FusionCharts, Charts, FusionTheme);

const IntensityChart = ({activityData}) => {
    // console.log(activityData)
    const [intensityData, setIntensityData] = useState([]);

    const dataSource = {
        chart: {
            caption: "Activity Intensities",
            captionFont:'Roboto',
            // subcaption: "For all users in 2017",
            showpercentvalues: "1",
            // defaultcenterlabel: "Android Distribution",
            aligncaptionwithcanvas: "0",
            captionpadding: "0",
            decimals: "1",
            plottooltext:
                "<b>$percentValue</b> of activities belong to <b>$label</b>",
            centerlabel: "# Users: $value",
            theme: "fusion"
        },
        data: intensityData
    };

    const chartConfigs = {
        type: "doughnut2d",
        width: "100%",
        height: "95%",
        dataFormat: "JSON",
        dataSource: dataSource
    };

    useEffect(() => {
        const intensityMap = new Map();
        for (let i of activityData) {
            if (!intensityMap.has(i.intensity)) {
                intensityMap.set(i.intensity, 1);
            } else {
                intensityMap.set(i.intensity, intensityMap.get(i.intensity) + 1);
            }
        }
        setIntensityData([...intensityMap].map((item) => {
            return {label: item[0], value: item[1]}
        }))

        // console.log(intensityData)
    }, [activityData])

    return (
        <div style={{display: 'block', margin: 'auto', width: '95%'}}>
            <ReactFC {...chartConfigs} />
        </div>
    )
}

export default IntensityChart;
