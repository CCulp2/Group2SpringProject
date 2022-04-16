import { Link } from 'react-router-dom';
import {   CssBaseline, Grid, Container, Button,  } from '@mui/material';

// This contains the blue tinted bar with the Men/Women buttons

function genderbar() {
    return (
        <>
        <CssBaseline />
        <Container disableGutters maxWidth="false" >
            <Grid container spacing={2} alignItems="center" justifyItems="center" justifyContent="center" sx={{ bgcolor: '#DCEEF2', height: '60px' }}>
                <Grid item>
                    <Link to="/Men">
                        <Button variant='outlined' color='secondary'>
                            Men
                        </Button>
                    </Link>    
                </Grid>
                <Grid item>
                    <Link to="/Women">
                        <Button variant='outlined' color='secondary'>
                            Women
                        </Button>
                    </Link>
                </Grid>
            </Grid>
        </Container>
        </>
    )
}

export default genderbar;
