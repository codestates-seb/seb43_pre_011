import { useEffect, useState } from "react";

const useCheckInput = (input, regex) => {
  const [isError, setIsError] = useState(true);
  useEffect(() => {
    if (regex.test(input)) {
      setIsError(false);
    } else {
      setIsError(true);
    }
  }, [input, regex]);
  return isError;
};

export default useCheckInput;
