import * as React from "react";
import { getItemsByGenderAndType } from "../Components/Items/ItemsService";
import ItemDisplayCard from "../Components/Items/ItemDisplayCard";
import { CssBaseline, Grid } from "@mui/material";

function MensPants() {
  const [items, setItems] = React.useState([]);

  React.useEffect(() => {
    getItemsByGenderAndType("MALE", "PANTS").then((data) => {
      return setItems(data);
    });
  }, []);

  return (
    <CssBaseline>
      <Grid container spacing={3}>
        {items.map(item => (
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

export default MensPants;
