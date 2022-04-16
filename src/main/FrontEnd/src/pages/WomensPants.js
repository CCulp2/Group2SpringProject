import { CssBaseline, Grid } from "@mui/material";
import * as React from "react";
import ItemDisplayCard from "../Components/Items/ItemDisplayCard";
import { getItemsByGenderAndType } from "../Components/Items/ItemsService";

function WomensPants() {
  const [items, setItems] = React.useState([]);

  React.useEffect(() => {
    getItemsByGenderAndType("FEMALE", "PANTS").then((data) => {
      return setItems(data);
    });
  }, []);

  return (
    <CssBaseline>
      <Grid container spacing={3}>
        {items.map((item) => (
          <Grid item xs={4}>
            <ItemDisplayCard
              productImgUrl={item.productImgUrl}
              name={item.name}
            />
          </Grid>
        ))}
      </Grid>
    </CssBaseline>
  );
}

export default WomensPants;
