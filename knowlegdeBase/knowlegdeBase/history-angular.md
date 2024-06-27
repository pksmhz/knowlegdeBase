# Angular version history


* Angular 18 May 22, 2024
  * Experimental zoneless change detection support and server-side rendering improvements.

* Angular 17	November 8, 2023
  * Application builder, a new syntax for control flow, and a re-worked learning and documentation website.
  
* Angular 16	3 May 2023
  * Partial hydration for Angular Universal's Server-side rendering, experimental Jest support, and Esbuild-based build system for development servers.
  
* Angular 15	November 18, 2022
  * Standalone APIs, directive composition API.
      Angular 14	2 June 2022	Typed forms, standalone components, and new primitives in the Angular CDK (component dev kit).
      Angular 13	4 November 2021[24]	Removed deprecated View Engine renderer.
      Angular 12	12 May 2021[25]	Deprecated support for Internet Explorer 11.
      Angular 11	11 November 2020[26]	Experimental Webpack 5 support
      Angular 10	24 June 2020[27]	New Date Range Picker (Material UI library).


# Angular 18
* Experimental support for zoneless change detection
* Angular.dev is now the new home for Angular developers
* Material 3, deferrable views, built-in control flow are now stable and incorporate a series of improvements
* Server-side rendering improvements such as i18n hydration support, better debugging, hydration support in Angular Material, and event replay powered by the same library as Google Search.

# Angular 17
* Boosting performance: Speed up builds with up to 87% faster hybrid rendering and up to 67% improvement in client side rendering.
* A sleek makeover, showcasing features in its fresh new look with all new interactive learning journey designed to make mastering Angular
* Revamped hybrid rendering experience with @angular/ssr package
* New lifecycle hooks: afterRender and afterNextRender
* New application builder: Vite and esbuild the default for new projects
* Dependency injection debugging capabilities in Angular DevTools
* All the ng generate commands will now scaffold standalone components, directives, and pipes
* Experimental view transitions support to enable transitions when changing DOM
* Style and styleUrls as strings


# Angular 16
* Angular Signals
* Server-side rendering and hydration
* Improved tooling for standalone components, directives, and pipes
* Advancing developer tooling
* Better unit testing with Jest and Web Test Runner

# Angular 15
* Standalone components API: Angular 15 made a lot of improvement in the standalone components API (introduced in Angular 14). This API allows developer to create Angular Application without using the ngModules. This API is now very stable.
* Directive composition API: The new directive composition API  lets you apply directives to a component’s host element from within the component TypeScript class.
* NgOptimizedImage: This API was introduced in Angular 14 is now stable and can be used in Production.
* Debugging: Angular15 Now offers more simplified stack errors.
* Dependency injection: providedIn: NgModule & providedIn: 'any' is now deprecated
* Angular Forms: New utility methods isFormControl, isFormGroup, isFormRecord, isFormArray, etc included in the Forms Module.

# Angular 14
* Strictly typed forms: The Angular forms module gets a makeover. Now you can create a Strictly typed form in Angular. We also have a new form element called FormRecord.
* Standalone components: You can now declare standalone components in Angular. Standalone components are not part of the ngModule. This implies that you can get rid of NgModules from your Angular Application
* Angular Router: The Router module gets a lot of improvements.
* Component: You can now use the function createComponent() to create components dynamically.

# Angular 13
* IE11: Support for IE 11 is dropped.
* View Engine: The support for View Engine stops starting from Angular 13. Ivy is now the only way to go.
* Angular Forms: Minor enhancements in the Forms Module related to strictly typed forms. The strictly typed forms are scheduled to be released in Angular 14.
* fullTemplateTypeCheck: is now deprecated.
* date pipe: has an optional second argument to specify the timezone or timezone offset.
* routerLink: If you give null or undefined to routerLink, then the Router will disable the navigation. Previous versions of Angular treated null or undefined as [] and navigated to the same page.

# Angular 12
* Ivy Everywhere: Angular 12 will deprecate the View Engine, a compilation and rendering pipeline. Ivy will become the new default rendering engine. Current libraries with View Engine will continue to work, but it will be removed entirely in the future versions
* Canonical message-ID format: legacy i18n message IDs were inconsistent in their translation because of whitespace and translation invalidation issues. In this version, Angular is migrating to a new standard message-id design, which is considerably better.
* End of Protractor: Protector is now excluded from Angular. The Angular team is presently reviewing Cypress, WebdriverIO, and TestCafe.
* Deprecating support for IE11: Angular will deprecate IE11 from the next version. The warning message will be displayed for IE11 in this version.
* Nullish Coalescing: Angular will not support Nullish Coalescing from this version. This will help us to write cleaner code.
* Default strict mode: The Angular CLI enables the strict mode by default. This will help developers to catch the bugs quickly.
* Styling improvements: This version will now inline SASS in the styles. Support for Tailwind CSS also comes with this version.