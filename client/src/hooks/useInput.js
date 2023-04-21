import { useState, useCallback } from "react";

const useInput = (initialDate) => {
  const [value, setValue] = useState(initialDate);
  const handler = useCallback((e) => {
    setValue(e.target.value);
  }, []);
  return [value, handler, setValue];
};

export default useInput;
