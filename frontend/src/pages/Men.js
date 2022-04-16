import {  CssBaseline } from "@mui/material";
import LeftNavBarMen from "../layout/leftnavbarMen";

// The Men function acts as a wrapper containing all of the menswear items.
// It routes the user from /Men into the filtered clothing categories.

function Men() {

    return  (
        <>
        <CssBaseline>
        {LeftNavBarMen()}
        </CssBaseline> 
        </>
    )
}

export default Men;
