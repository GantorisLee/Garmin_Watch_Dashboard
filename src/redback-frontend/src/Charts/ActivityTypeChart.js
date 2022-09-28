import React, {useEffect, useState} from 'react';
import FusionCharts from 'fusioncharts';
import Charts from 'fusioncharts/fusioncharts.charts';
import ReactFC from 'react-fusioncharts';
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';

// Resolves charts dependancy
ReactFC.fcRoot(FusionCharts, Charts, FusionTheme);

const ActivityTypeChart = ({activityData}) => {
    const [activityTypeData, setActivityTypeData] = useState([]);
    // let activityTypeData = [];
    const dataSource = {
        chart: {
            caption: "Activity Types",
            captionFont:'Roboto',
            // subcaption: "For all users in 2017",
            showpercentvalues: "1",
            // defaultcenterlabel: "Android Distribution",
            aligncaptionwithcanvas: "0",
            captionpadding: "0",
            decimals: "1",
            plottooltext:
                "<b>$percentValue</b> of activities are <b>$label</b>",
            centerlabel: "# Users: $value",
            theme: "fusion"
        },
        data:activityTypeData
    };

    const chartConfigs = {
        type: "pie2d",
        width: "100%",
        height: "95%",
        dataFormat: "JSON",
        dataSource: dataSource
    };

    useEffect(() => {
        const activityTypeMap = new Map();
        for (let i of activityData) {
            if (!activityTypeMap.has(i.activityType)) {
                activityTypeMap.set(i.activityType, 1);
            } else {
                activityTypeMap.set(i.activityType, activityTypeMap.get(i.activityType) + 1);
            }
        }
        setActivityTypeData([...activityTypeMap].map((item) => {
            return {label: item[0], value: item[1]}
        }))

        // console.log(activityTypeData)
    }, [activityData])

    return (
        <div style={{display: 'block', margin: 'auto', width: '95%'}}>
            <ReactFC {...chartConfigs} />
        </div>
    )
}

export default ActivityTypeChart;