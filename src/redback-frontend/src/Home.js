import React from "react";
import {Button} from 'antd';
import axios from "axios";
// require('dotenv').config();
const authUrl = "https://lk-redback2.herokuapp.com/auth/requestToken";
const Home = ({user}) => {
    console.log("user: ", user)

    if (!user) {
        return (
            <>
                <h1>Please Login at first!</h1>
            </>
        )
    } else {
        const {email, fullname, username, userId, userAccessToken} = user;

        const handlePermission = () => {
            axios({
                method: "POST",
                url: `${authUrl}`,
                headers: {
                    // "Access-Control-Allow-Origin": "*",
                    Accept: "*/*",
                    // "Content-Type": "application/json",
                    // "Access-Control-Allow-Methods": "POST, GET, OPTIONS, DELETE, PUT",
                },
                // data: bodyFormData,
                params: {
                    username: username,
                },
            })
                .then((res) => {
                    console.log("res: ", res);
                    window.open(res.data.url);
                })
                .catch((error) => console.log("error: ", error));
        }
        if (userAccessToken) {
            return (
                <>
                    <h1>Dashboard</h1>
                    <h2>You have already connected to Garmin!</h2>
                    <h3>{username} Welcome!</h3>
                </>
            )
        } else {
            return (
                <>
                    <div style={{height:'100vh', display:'flex', justifyContent:'center', alignItems:'center', flexDirection:'column'}}>
                    <h1 style={{fontWeight:'bold'}}>You have not connected to Garmin yet!</h1>
                    <Button shape="round" type="primary" onClick={handlePermission} >Connect</Button>
                    </div>
                </>
            )
        }

    }

}

export default Home;