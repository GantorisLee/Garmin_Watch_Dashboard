import {Layout} from 'antd';
import 'antd/dist/antd.less'
import './StyleSheet/dashboardStyle.css'
import SwimTable from "./SwimTable";
import RunTable from "./RunTable";
import BikeTable from "./BikeTable";
// import {UserContext} from "./App";
const {Header, Content, Footer} = Layout;

const ActivityDetails = ({user}) => {
    return (
        <>
            <Content
                style={{
                    margin: '0 16px',
                }}
            >
                <div
                    className="site-layout-background"
                    style={{
                        margin: '16px 0',
                        padding: 24,
                        minHeight: 360,
                    }}
                >
                    <span className={'tableHeader'}>Swim Activities</span>
                    <SwimTable/>
                    <span className={'tableHeader'}>Bike Activities</span>
                    <BikeTable/>
                    <span className={'tableHeader'}>Run Activities</span>
                    <RunTable/>
                </div>
            </Content>

        </>
    )
}

export default ActivityDetails;