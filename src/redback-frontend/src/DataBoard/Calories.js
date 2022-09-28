import {useEffect, useState} from "react";

const Calories = ({activityData}) => {
    const [totalCalories, setTotalCalories] = useState([])

    useEffect(() => {
        setTotalCalories(activityData.reduce((pre, cur) =>
            pre + cur.activeKilocalories, 0
        ))
    }, [activityData])

    return (
        <>
            <h1 className={'dataHeader'}>TOTAL CALORIES</h1>
            <span className={'dataText'}>{totalCalories}</span>
        </>
    )
}

export default Calories;