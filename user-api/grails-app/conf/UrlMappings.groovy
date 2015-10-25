class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            action = [GET:"show", POST:"save", PUT:"update", DELETE:"remove"]
            constraints {
                // apply constraints here
            }
        }

        "/users/"(controller: 'users', parseRequest: false){
            action = [ PUT: "update", POST: "save", GET: "show"]
        }



        "/"(view:"/index")
        "500"(view:'/error')
	}
}
