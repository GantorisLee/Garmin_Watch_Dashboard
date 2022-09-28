import React from "react";
import {createRoot} from "react-dom/client";
import {App} from "./App";
import 'antd/dist/antd.min.css';
import './StyleSheet/dashboardStyle.css';

const root = createRoot(document.getElementById('root'));
root.render(<App />);

