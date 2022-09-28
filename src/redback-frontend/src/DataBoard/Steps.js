import '../StyleSheet/dashboardStyle.css'
import {useEffect, useState} from "react";

const Steps = ({activityData}) => {
    const [totalSteps, setTotalSteps] = useState([])

    useEffect(() => {
        setTotalSteps(activityData.reduce((pre, cur) =>
            pre + cur.steps, 0
        ))
    }, [activityData])

    return (
        <>
            <h1 className={'dataHeader'}>TOTAL STEPS</h1>
            <span className={'dataText'}>{totalSteps}</span>
        </>
    )
}

export default Steps;