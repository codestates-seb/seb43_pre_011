// 전역 CSS 작성
import { createGlobalStyle } from "styled-components";
// eslint-disable-next-line import/no-named-as-default
import reset from "styled-reset";

const GlobalStyle = createGlobalStyle`
/* Reset CSS */
${reset}

/* custom style */
:root {
	--white: #fff;
	--black: #0c0d0e;
	--gray: #525960;
	--orange: #f48225;
	--input-border: #babfc4;
	--box-border: #d6d9dc;
	--header-gray: #838c95;
	--link:  #0074cc;
	--link-hover:  #0a95ff;
	--light-blue: #6bbbf7;
	--bg-gray: #f8f9f9;
	--hover-gray: #e3e6e8;
<<<<<<< HEAD
=======
	--side-bg: #fdf7e2;
	--side-title: #fbf3d5;
	--side-border: #f1e5bc;
>>>>>>> 9d88cff7d62857f8b40aa32c1cc05f9100bc16db
}

* {
  box-sizing:  border-box;
}

html {
	font-size: 62.5%;
}

body {
	font-size: 1.3rem;
	color: var(--black)
}

a {
	text-decoration: none;
	color: inherit;
}


button {
	border: 0;
	background: transparent;
	padding: 0;
	cursor: pointer;
}
`;

export default GlobalStyle;
