import {Table, Modal} from 'antd';
import {useContext, useEffect, useState} from "react";
import {UserContext} from "./App";
import axios from "axios";
import DetailsModal from "./DetailsModal";
import './StyleSheet/dashboardStyle.css';

const rootURL = process.env.REACT_APP_API_URL;
const columns = [
    {
        title: 'Time',
        dataIndex: 'time',
        defaultSortOrder: 'descend',
        sorter: (a, b) => a.time - b.time,
    },
    {
        title: 'Distance',
        dataIndex: 'distance',
        sorter: (a, b) => a.distance - b.distance,
    },
    {
        title: 'Avg Speed',
        dataIndex: 'avgSpeed',
        sorter: (a, b) => a.avgSpeed - b.avgSpeed,
    },
    {
        title: 'Calories',
        dataIndex: 'calories',
        sorter: (a, b) => a.calories - b.calories,
    },
    {
        title: 'Pace in time per km',
        dataIndex: 'pace',
        sorter: (a, b) => a.pace - b.pace,
    },
    {
        title: 'Ave Cadence',
        dataIndex: 'cadence',
        sorter: (a, b) => a.cadence - b.cadence,
    },
    {
        title: 'Heart Rate Ave',
        dataIndex: 'heartRate',
        sorter: (a, b) => a.heartRate - b.heartRate,
    },
    {
        title: 'Elevation',
        dataIndex: 'elevation',
        sorter: (a, b) => a.elevation - b.elevation
    },
    // {
    //     title: '',
    //     dataIndex: '',
    //     defaultSortOrder: 'descend',
    //     sorter: (a, b) => a. - b.,
    // },
];

const RunTable = () => {
    const [isModalVisible, setIsModalVisible] = useState(false);
    const {user: {userAccessToken}} = useContext(UserContext);
    const [runData, setRunData] = useState([]);
    const [detailsData, setDetailsData] = useState([]);
    const [loading, isLoading] = useState(true);
    useEffect(() => {
        axios({
            method: "GET",
            url: `${rootURL}/activity/getRunningActivityByAccessToken`,
            headers: {
                // "Access-Control-Allow-Origin": "*",
                Accept: "application/json",
                // "Content-Type": "application/json",
                // "Access-Control-Allow-Methods": "POST, GET, OPTIONS, DELETE, PUT",
            },
            // data: bodyFormData,
            params: {
                accessToken: userAccessToken,
            },
        })
            .then((res) => {
                // console.log("res: ", res);
                setRunData(res.data.map(({
                                             time,
                                             distance,
                                             avgSpeed,
                                             pace,
                                             calories,
                                             details,
                                             heartRate,
                                             avgCadence
                                         }, key) => {
                    return {
                        key: key,
                        time: time,
                        distance: distance,
                        avgSpeed: avgSpeed,
                        pace: pace,
                        calories: calories,
                        details: details,
                        heartRate: heartRate,
                        avgCadence: avgCadence
                    }
                }))
                isLoading(false);
            })
            .catch((error) => {
                console.log("error: ", error)
            });
    }, [])

    const showModal = () => {
        setIsModalVisible(true);
    };

    const handleCancel = () => {
        setIsModalVisible(false)
    };

    const rowSelection = {
        onChange: (selectedRowKeys, selectedRows) => {
            showModal();
            // console.log(data.filter(item=>item.key == selectedRowKeys))
            console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
            setDetailsData(runData.filter(item => item.key == selectedRowKeys)[0]);
            // console.log(runData)
        },
        // getCheckboxProps: (record) => ({
        //     disabled: record.name === 'Disabled User',
        //     // Column configuration not to be checked
        //     name: record.name,
        // }),
    };

    function onChange(pagination, filters, sorter, extra) {
        console.log('params', pagination, filters, sorter, extra);
    }

    return (
        <>
            <Modal title="Details" width={800} onCancel={handleCancel} visible={isModalVisible}
                   footer={null}><DetailsModal detailsData={detailsData}/></Modal>
            <Table loading={loading} rowSelection={{
                type: 'radio',
                ...rowSelection,
            }} columns={columns} dataSource={runData} onChange={onChange}/>
        </>
    )
}

export default RunTable;