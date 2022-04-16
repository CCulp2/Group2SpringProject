import { Typography, Paper, Grid, CssBaseline } from '@mui/material';

// This is the page that is displayed when the user tries to access an item that does not exist.

function ItemNotFound() {
  
  return(
    <>
      <CssBaseline>
      <Paper elevation={3} sx={{ pt: "60px", marginY: 5, marginX: "auto", maxWidth: "750px", minHeight: "500px" }}>
        <Grid container spacing={8}>
            <Grid item xs={12} sx={{ textAlign: "center"}}>
              <Typography variant="h4" color="secondary" component="h3">
                The item you are looking for is not found.
              </Typography>
            </Grid>
              <Grid item xs={12} sx={{ textAlign: "center"}}>
                <Typography variant="h5" component="h3">
                  Please check the URL and try again.
                </Typography>
            </Grid>
        </Grid>
      </Paper>
      </CssBaseline>
    </>
  );
}

export default ItemNotFound;
