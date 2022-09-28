import {Link} from "react-router-dom";

const NavBar = () => {
    return (
        <>
            <Link to={'/'}>Login</Link>
            <Link to={'signup'}>SignUp</Link>
        </>
    )
}

export default NavBar;