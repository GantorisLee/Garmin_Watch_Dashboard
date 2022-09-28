import React, {useEffect, useState} from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./Login";
import Signup from "./Signup";
import Home from "./Home";
import Dashboard from "./Dashboard";
import ApiTest from "./ApiTest";
import ActivityDetails from "./ActivityDetails";

const UserContext = React.createContext(null);
function App() {
    // const [user, setUser] = useState(null);
    const [user, setUser] = useState(JSON.parse(sessionStorage.getItem('user')));
    useEffect(() => {
        // console.log(JSON.parse(sessionStorage.getItem('user')))
        setUser(JSON.parse(sessionStorage.getItem('user')))
    }, [])

    return (
        <>
            <UserContext.Provider value={{user}}>
                <BrowserRouter>
                    {/*<NavBar/>*/}
                    <Routes>
                        <Route path={"/"} element={<Login setUser={setUser}/>}/>
                        <Route path={'signup'} element={<Signup/>}/>
                        <Route path={'home'} element={<Home user={user}/>}/>
                        <Route path={'dashboard'} element={<Dashboard user={user}/>}/>
                        <Route path={'activitydetails'} element={<ActivityDetails user={user}/>}/>
                        <Route path={'apitest'} element={<ApiTest user={user}/>}/>
                    </Routes>
                </BrowserRouter>
            </UserContext.Provider>
        </>
    )
}

export {App, UserContext};
