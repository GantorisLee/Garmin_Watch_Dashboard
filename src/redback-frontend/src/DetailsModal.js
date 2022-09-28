import FusionCharts from "fusioncharts";
import Charts from "fusioncharts/fusioncharts.charts";
import ReactFC from "react-fusioncharts";
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';
import {useEffect, useState} from "react";
import {Radio} from 'antd';

ReactFC.fcRoot(FusionCharts, Charts, FusionTheme);

const DetailsModal = ({detailsData: {details}}) => {
    const [heartRateData, setHeartRateData] = useState([]);
    const [speedData, setSpeedData] = useState([]);
    const [value, setValue] = useState(1);

    const onChange = e => {
        console.log('radio checked', e.target.value);
        setValue(e.target.value);
    };

    useEffect(() => {
        setHeartRateData(details.map(({heartRate}, key) => {
            return {value: heartRate, label: key};
        }))
        setSpeedData(details.map(({speedMetersPerSecond}, key) => {
            return {value: speedMetersPerSecond, label: key}
        }))
    }, [details])

    const heartRateDataSource = {
        chart: {
            caption: "Heart Rate",
            yaxisname: "BPM",
            // subcaption: "2007-2016",
            legendposition: "Right",
            drawanchors: "0",
            showvalues: "0",
            plottooltext: "<b>$dataValue</b> BPM",
            theme: "fusion"
        },

        // data: [
        //     {
        //         label: "1",
        //         value: "138"
        //     },
        //     {
        //         label: "2",
        //         value: "145"
        //     },
        //     {
        //         label: "3",
        //         value: "111"
        //     },
        //     {
        //         label: "4",
        //         value: "91"
        //     },
        // ]
        data: heartRateData
    };

    const speedDataSource = {
        chart: {
            caption: "Speed",
            yaxisname: "Meters Per Second",
            // subcaption: "2007-2016",
            legendposition: "Right",
            drawanchors: "0",
            showvalues: "0",
            plottooltext: "<b>$dataValue</b> meters per second",
            theme: "fusion"
        },

        // data: [
        //     {
        //         label: "1",
        //         value: "1"
        //     },
        //     {
        //         label: "2",
        //         value: "2"
        //     },
        //     {
        //         label: "3",
        //         value: "1"
        //     },
        //     {
        //         label: "4",
        //         value: "2"
        //     },
        // ]
        data: speedData
    };

    return (
        <>
            <Radio.Group onChange={onChange} value={value} style={{display: 'flex', justifyContent: 'center'}}>
                <Radio value={1}>Heart Rate</Radio>
                <Radio value={2}>Speed</Radio>
            </Radio.Group>
            <ReactFC
                type="area2d"
                width="100%"
                height="400"
                dataFormat="JSON"
                dataSource={value === 1 ? heartRateDataSource : speedDataSource}
            />
        </>
    );
}

export default DetailsModal;