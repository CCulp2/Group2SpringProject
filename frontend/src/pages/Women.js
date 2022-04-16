import { CssBaseline } from "@mui/material";
import LeftNavBarWomen from "../layout/leftnavbarWomen";

// The Women function acts as a wrapper containing all of the women's items.
// It routes the user from /Women into the filtered clothing categories.

function Women() {
    return (
        <>
        <CssBaseline>
            {LeftNavBarWomen()}
        </CssBaseline>
        </>
    )
        
}

export default Women;
