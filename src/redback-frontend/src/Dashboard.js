import {Layout, Menu} from 'antd';
import 'antd/dist/antd.less'
import DataLayout from "./DataLayout";
import './StyleSheet/dashboardStyle.css';
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {ApiOutlined, DatabaseOutlined, PieChartOutlined, UserOutlined} from "@ant-design/icons";
import ActivityDetails from "./ActivityDetails";
// import {UserContext} from "./App";
const {Header, Content, Footer, Sider} = Layout;

const Dashboard = ({user}) => {
    const [isCollapsed, setIsCollapsed] = useState(false)
    const onCollapse = (collapsed) => {
        // console.log(collapsed);
        setIsCollapsed(collapsed)
    };
    const navigate = useNavigate();

    const [currentContent, setCurrentContent] = useState('Dashboard');

    const onContentChange = (content) => {
        setCurrentContent(content);
    }

    const switchContent = (content)=>{
        switch (content){
            case 'Dashboard':
                return <DataLayout user={user}/>
            case 'Activities':
                return <ActivityDetails user={user}/>
            default: return <DataLayout user={user}/>
        }
    }

    return (
        <>
            <Layout
                style={{
                    minHeight: '100vh',
                }}
            >
                <Sider collapsible collapsed={isCollapsed} onCollapse={onCollapse}>
                    <div className="logo"/>
                    <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                        <Menu.Item key="1">
                            {/*<Icon type="desktop" />*/}
                            <PieChartOutlined/>
                            <span onClick={() => onContentChange('Dashboard')}>Dashboard</span>
                        </Menu.Item>
                        <Menu.Item key="2">
                            {/*<Icon type="desktop" />*/}
                            <DatabaseOutlined/>
                            <span onClick={() => onContentChange('Activities')}>Activities</span>
                        </Menu.Item>
                        <Menu.Item key="3">
                            {/*<Icon type="file" />*/}
                            <ApiOutlined />
                            <span onClick={() => navigate('/apitest')}>API Test</span>
                        </Menu.Item>
                        <Menu.Item key="4">
                            {/*<Icon type="pie-chart" />*/}
                            <UserOutlined/>
                            <span>{user.username}</span>
                        </Menu.Item>
                    </Menu>
                </Sider>
                <Layout className="site-layout">
                    <Header
                        className="site-layout-background"
                        style={{
                            background: '#fff',
                            fontSize: '2rem',
                            fontWeight: "bold",
                            paddingLeft: '3rem'
                        }}
                    >
                        {currentContent}
                    </Header>
                    <Content
                        style={{
                            margin: '0 16px',
                        }}
                    >
                        <div
                            className="site-layout-background"
                            style={{
                                margin: '16px 0',
                                padding: 10,
                                minHeight: 360,
                            }}
                        >
                            {switchContent(currentContent)}
                        </div>
                    </Content>
                    <Footer
                        style={{
                            textAlign: 'center',
                        }}
                    >
                        Garmin Dashboard ©2022 Created by Redback
                    </Footer>
                </Layout>
            </Layout>
        </>
    )
}

export default Dashboard;