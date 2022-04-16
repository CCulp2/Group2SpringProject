import { Box, CssBaseline, Link } from "@mui/material";

// This is the footer of the page
// It will be displayed at the bottom of every page

function Footer() {
  return (
    <>
    <CssBaseline>
    <Box
      sx={{ marginTop: "1rem",
      padding: "1rem",
      position: "fixed",
      bottom: 0,
      left: 0,
      width: "100%",
          }}
      bgcolor= "#C7CFD9"
      color= "#025E73"
      textAlign="center"
      >
      <Link target="_blank"
      href="https://github.com/CCulp2/Group2SpringProject-FrontEnd"
      rel="noreferrer"
      color="#025E73">
      Find us on Github
      </Link>
    </Box>
    </CssBaseline>
    </>
  );
}

export default Footer;
