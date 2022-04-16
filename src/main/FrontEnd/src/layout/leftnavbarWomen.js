import { Typography, CssBaseline,  Box,  Tabs, Tab } from '@mui/material';
import PropTypes from 'prop-types';
import * as React from 'react';
import WomensTops from '../pages/WomensTops';
import WomensPants from '../pages/WomensPants';
import WomensShorts from '../pages/WomensShorts';
import WomensSweaters from '../pages/WomensSweaters';

// This creates a component that will render the content of the tab panel
function TabPanel(props) {
    const { children, value, index, ...other } = props;

    return (
        <div
            role="tabpanel"
            hidden={value !== index}
      // eslint-disable-next-line
            id={'vertical-tabpanel-${index}'}
      // eslint-disable-next-line
            aria-labelledby={'vertical-tab-${index}'}
            {...other}
            >
                {value === index && (
                    <Box sx={{ p: 3 }}>
                        <Typography>{children}</Typography>
                    </Box>
                )}
            </div>
    );
}

TabPanel.propTypes = {
    children: PropTypes.node,
    index: PropTypes.number.isRequired,
    value: PropTypes.number.isRequired,
};

function a11yProps(index) {
    return {
      // eslint-disable-next-line
        id: 'vertical-tab-${index}',
      // eslint-disable-next-line
        'aria-controls': 'vertical-tabpanel-${index}',
    };
}

// This renders the content of the tab panel

function LeftNavBarWomen() {
    const [value, setValue] = React.useState(0);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <>
        <CssBaseline />
        <Box sx={{ flexGrow: 1, bgcolor: 'background.paper', display: 'flex', height: 500 }}>
            <Tabs
                orientation="vertical"
                variant="scrollable"
                value={value}
                onChange={handleChange}
                aria-label="LeftNavBar"
                sx={{ borderRight: 1, borderColor: 'divider' }}>
                    <Tab label='Tops' {...a11yProps(0)} />
                    <Tab label='Pants' {...a11yProps(1)} />
                    <Tab label='Shorts' {...a11yProps(2)} />
                    <Tab label='Sweaters' {...a11yProps(3)} />                   
            </Tabs>
            <TabPanel value={value} index={0}>
                {WomensTops()}
            </TabPanel>
            <TabPanel value={value} index={1}>
                {WomensPants()}
            </TabPanel>
            <TabPanel value={value} index={2}>
                {WomensShorts()}
            </TabPanel>
            <TabPanel value={value} index={3}>
                {WomensSweaters()}
            </TabPanel>
        </Box>
        
        </>
    )
}

export default LeftNavBarWomen;
