import {Button, Col, Form, Input, message, Row} from 'antd';
import axios from "axios";
import {useNavigate} from "react-router-dom";

const rootURL = process.env.REACT_APP_API_URL;
// const signupUrl = "https://lk-redback2.herokuapp.com/register";
const Signup = () => {
    // const [isRegistered, setIsRegistered] = useState(false);
    const navigate = useNavigate();
    const onFinish = (values) => {
        console.log('Success:', values);
        axios({
                method: "post",
                url: `${rootURL}/register`,
                // url: "http://localhost:8080/register",
                //https://coaching-mate0121.herokuapp.com/register`
                headers: {
                    "Accept": '*/*',
                    // "Content-Type": "application/json",
                    // "Access-Control-Allow-Origin": "*",
                    // "Access-Control-Allow-Credentials": "true",
                },
                params: {
                    username: values.username,
                    password: values.password,
                    fullname: values.fullname,
                    email: values.email,
                },
                // data:bodyFormData
                // mode: "no-cors",
            }
        )
            .then((res) => {
                message.success('You have successfully signed up!');
                console.log("response", res)
                // redirect to home page
                // this.props.history.push({
                //     pathname: '/',
                // })
                // setIsRegistered(true);
            })
            .catch((error) => {
                message.error("Error");
                console.log("error: ", error)
            })
    };

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
        <>
            <div className={'loginBackground'}>
                <Row style={{height: "100vh", fontWeight:'bold'}} justify="center" align="middle">
                    <Col span={8}>
                        {/*{isRegistered ? <span>Registered Successfully</span> : <span></span>}*/}
                        <div className={'loginBoard'}>
                            <h1 style={{textAlign: 'center', fontWeight:'bold'}}>Signup</h1>
                            <Form
                                name="basic"
                                labelCol={{
                                    span: 8,
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
                                    label="Email"
                                    name="email"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please input your email!',
                                        },
                                    ]}
                                >
                                    <Input/>
                                </Form.Item>

                                <Form.Item
                                    label="Full Name"
                                    name="fullname"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please input your full name!',
                                        },
                                    ]}
                                >
                                    <Input/>
                                </Form.Item>

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

                                {/*<Form.Item*/}
                                {/*    wrapperCol={{*/}
                                {/*        offset: 8,*/}
                                {/*        // span: 8,*/}
                                {/*    }}*/}
                                {/*>*/}
                                    <Button type="primary" htmlType="submit" shape="round" style={{display: "block", margin: 'auto', width: '10rem', fontWeight: 'bold'}}>
                                        SignUp
                                    </Button>
                                <a onClick={() => navigate('/')} style={{
                                    display: "block",
                                    textAlign: 'center',
                                    paddingTop: '1rem',
                                    fontWeight: 'bold'
                                }}>Login your account!</a>
                                {/*</Form.Item>*/}
                            </Form>
                        </div>
                    </Col>
                </Row>
            </div>
        </>
    );
};

export default Signup;