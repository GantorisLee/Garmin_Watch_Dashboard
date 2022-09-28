import {Button, Checkbox, Col, Form, Input, message, Row} from 'antd';
import axios from "axios";
import {useNavigate} from "react-router-dom";
import './StyleSheet/dashboardStyle.css';

const rootURL = process.env.REACT_APP_API_URL;
// const loginUrl = "https://lk-redback2.herokuapp.com/login";
const Login = ({setUser}) => {
        const navigate = useNavigate();
        const onFinish = (values) => {
            console.log('Success:', values);
            axios({
                method: "post",
                url: `${rootURL}/login`,
                // url: "http://localhost:8080/login",
                //https://coaching-mate0121.herokuapp.com/login
                headers: {
                    Accept: "*/*",
                    // "Content-Type": "application/json",
                    // "Access-Control-Allow-Origin": "*",
                    // "Access-Control-Allow-Credentials": "true",
                },
                params: {
                    username: values.username,
                    password: values.password
                },
                //data: bodyFormData
                //mode: "no-cors",
            })
                .then((res) => {
                    console.log("response: ", res);
                    // this.setState({user: res.data})
                    // console.log('user is ',this.state.user)
                    // redirect to home page
                    // setUser(res.data);
                    sessionStorage.setItem('user', JSON.stringify(res.data));
                    console.log(typeof (JSON.parse(sessionStorage.getItem('user'))));
                    setUser(JSON.parse(sessionStorage.getItem('user')));
                    if (res.data.userAccessToken) {
                        navigate('/dashboard');
                    } else {
                        navigate('/home');
                    }
                })
                .catch((error) => {
                    // this.setState({ isShow: true });
                    message.error("Error");
                    console.log("error: ", error);
                });
        };

        const onFinishFailed = (errorInfo) => {
            console.log('Failed:', errorInfo);
        };

        return (
            <>
                {/*<div style={{background: '#319de5'}}>*/}
                <div className={'loginBackground'}>
                    <Row style={{height: "100vh", fontWeight:'bold'}} justify="center" align="middle">
                        <Col span={6}>
                            <div className={'loginBoard'}>
                                {/*<div style={{background: '#3498db'}}>*/}
                                <h1 style={{textAlign: 'center', fontWeight:'bold'}}>Login</h1>
                                {/*</div>*/}
                                <Form
                                    name="basic"
                                    labelCol={{
                                        span: 8
                                    }}
                                    wrapperCol={{
                                        span: 10,
                                    }}
                                    initialValues={{
                                        remember: true,
                                    }}
                                    onFinish={onFinish}
                                    onFinishFailed={onFinishFailed}
                                    autoComplete="off"
                                >
                                    <Form.Item
                                        label="Username"
                                        name="username"
                                        rules={[
                                            {
                                                required: true,
                                                message: 'Please input your username!',
                                            },
                                        ]}
                                    >
                                        <Input/>
                                    </Form.Item>

                                    <Form.Item
                                        label="Password"
                                        name="password"
                                        rules={[
                                            {
                                                required: true,
                                                message: 'Please input your password!',
                                            },
                                        ]}
                                    >
                                        <Input.Password/>
                                    </Form.Item>

                                    <Form.Item
                                        name="remember"
                                        valuePropName="checked"
                                        wrapperCol={{
                                            offset: 8,
                                            span: 16,
                                        }}
                                    >
                                        <Checkbox>Remember me</Checkbox>
                                    </Form.Item>

                                    {/*<Form.Item*/}
                                    {/*    wrapperCol={{*/}
                                    {/*        offset: 10.5,*/}
                                    {/*        span: 14,*/}
                                    {/*    }}*/}
                                    {/*>*/}
                                    <Button type="primary" htmlType="submit" shape="round"
                                            style={{display: "block", margin: 'auto', width: '10rem', fontWeight: 'bold'}}>
                                        LOGIN
                                    </Button>
                                    <a onClick={() => navigate('/signup')} style={{
                                        display: "block",
                                        textAlign: 'center',
                                        paddingTop: '1rem',
                                        fontWeight: 'bold'
                                    }}>Register an account!</a>
                                </Form>
                            </div>
                        </Col>
                    </Row>
                </div>
            </>
        );
    }
;

export default Login;